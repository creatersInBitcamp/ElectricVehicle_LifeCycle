package com.bitcamp.team_project_eco.usedCarSales;

import com.bitcamp.team_project_eco.electriccar.QElectricCar;
import com.bitcamp.team_project_eco.usedCar.QUsedCar;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.bitcamp.team_project_eco.usedCar.QUsedCar.usedCar;
import static com.bitcamp.team_project_eco.usedCarSales.QUsedCarSales.usedCarSales;
import static com.bitcamp.team_project_eco.electriccar.QElectricCar.*;

interface IUsedCarSalesRepository {

    List<SalesVO> getInfo();

    List<UsedCarSales> findByUsedCarId(long parseLong);
}

@Repository
public class UsedCarSalesRepositoryImpl extends QuerydslRepositorySupport implements IUsedCarSalesRepository {

    /**
     * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
     *
     * @param domainClass must not be {@literal null}.
     */

    private final JPAQueryFactory queryFactory;

    public UsedCarSalesRepositoryImpl(JPAQueryFactory queryFactory) {
        super(UsedCarSales.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public List<SalesVO> getInfo() {
        List<SalesVO> list = queryFactory.select(Projections.fields(SalesVO.class,
                usedCar.usedCarId,
                usedCarSales.buyerAddr,
                usedCarSales.buyerEmail,
                usedCarSales.buyerName,
                usedCarSales.buyerPhoneNumber,
                usedCarSales.reqId))
                .from(usedCarSales)
                .innerJoin(usedCar).on(usedCar.usedCarId.eq(usedCarSales.usedCar.usedCarId))
                .fetch();
        return list;

    }

    @Override
    public List<UsedCarSales> findByUsedCarId(long parseLong) {
        List<UsedCarSales> list = queryFactory.select(Projections.fields(UsedCarSales.class,
                usedCar.usedCarId,
                usedCarSales.reqId,
                usedCarSales.buyerPhoneNumber,
                usedCarSales.buyerName,
                usedCarSales.buyerAddr,
                usedCarSales.buyerEmail,
                usedCarSales.carName))
                .from(usedCarSales)
                .innerJoin(usedCar).on(usedCar.usedCarId.eq(usedCarSales.usedCar.usedCarId))
                .where(usedCarSales.usedCar.usedCarId.eq(parseLong))
                .fetch();
        return list;
    }
}
