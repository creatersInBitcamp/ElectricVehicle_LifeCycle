package com.bitcamp.team_project_eco.usedCar;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import static com.bitcamp.team_project_eco.electriccar.QElectricCar.*;
import static com.bitcamp.team_project_eco.usedCar.QUsedCar.*;
import static com.bitcamp.team_project_eco.user.QUser.*;
import java.util.List;

interface IUsedCarRepository {
    
    List<UsedCarVO> detail();

    List<CarInfo> carInfo();

    List<CarInfo> findByUsedCarId(long parseLong);

    List<CarInfo> findByUserSeq(long parseLong);
}

@Repository
public class UsedCarRepositoryImpl extends QuerydslRepositorySupport implements IUsedCarRepository {

    /**
     * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
     *
     * @param domainClass must not be {@literal null}.
     */

    private final JPAQueryFactory queryFactory;
    public UsedCarRepositoryImpl(JPAQueryFactory queryFactory) {
        super(UsedCar.class);
        this.queryFactory = queryFactory;
    }


    @Override
    public List<UsedCarVO> detail() {
        List<UsedCarVO> list = queryFactory.select(Projections.fields(UsedCarVO.class,
                electricCar.eccarId,
                user.userSeq,
                usedCar.price,
                usedCar.age,
                usedCar.mileage))
                .from(usedCar)
                .innerJoin(user).on(user.userSeq.eq(usedCar.user.userSeq))
                .innerJoin(electricCar).on(electricCar.eccarId.eq(usedCar.electricCar.eccarId))
                .fetch();
        return list;
    }

    @Override
    public List<CarInfo> carInfo() {
        List<CarInfo> list = queryFactory.select(Projections.fields(CarInfo.class,
                usedCar.usedCarId,
                usedCar.price,
                usedCar.age,
                usedCar.mileage,
                usedCar.img,
                usedCar.user,
                electricCar.carName,
                electricCar.yyyy,
                electricCar.modelName,
                electricCar.trim,
                electricCar.brand))
                .from(usedCar)
                .innerJoin(electricCar).on(electricCar.eccarId.eq(usedCar.electricCar.eccarId))
                .fetch();
        return list;
    }

    @Override
    public List<CarInfo> findByUsedCarId(long parseLong) {
        List<CarInfo> list = queryFactory.select(Projections.fields(CarInfo.class,
                usedCar.usedCarId,
                usedCar.price,
                usedCar.age,
                usedCar.mileage,
                usedCar.img,
                usedCar.user,
                electricCar.carName,
                electricCar.yyyy,
                electricCar.modelName,
                electricCar.trim,
                electricCar.brand))
                .from(usedCar)
                .innerJoin(electricCar).on(electricCar.eccarId.eq(usedCar.electricCar.eccarId))
                .where(usedCar.usedCarId.eq(parseLong))
                .fetch();
        return list;
    }

    @Override
    public List<CarInfo> findByUserSeq(long parseLong) {
        List<CarInfo> list = queryFactory.select(Projections.fields(CarInfo.class,
                usedCar.usedCarId,
                usedCar.price,
                usedCar.age,
                usedCar.mileage,
                usedCar.img,
                usedCar.user,
//                electricCar.img,
                electricCar.carName,
                electricCar.yyyy,
                electricCar.modelName,
                electricCar.trim,
                electricCar.brand))
                .from(usedCar)
                .innerJoin(electricCar).on(electricCar.eccarId.eq(usedCar.electricCar.eccarId))
                .where(usedCar.user.userSeq.eq(parseLong))
                .fetch();
        return list;
    }
}
