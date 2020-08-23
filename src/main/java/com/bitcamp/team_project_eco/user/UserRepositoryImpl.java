package com.bitcamp.team_project_eco.user;

import com.amazonaws.services.dynamodbv2.xspec.S;
import com.bitcamp.team_project_eco.join.AdminUsedCar;
import com.bitcamp.team_project_eco.usedCar.UsedCar;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

import static com.bitcamp.team_project_eco.usedCar.QUsedCar.*;
import static com.bitcamp.team_project_eco.user.QUser.*;
import static com.bitcamp.team_project_eco.electriccar.QElectricCar.*;
interface CustomUserRepository {
    List<AdminUsedCar> findAdminUsedCar();


    //int[] counting();
}
@Repository
public class UserRepositoryImpl extends QuerydslRepositorySupport implements CustomUserRepository{

    private final  JPAQueryFactory queryFactory;
    public UserRepositoryImpl(JPAQueryFactory queryFactory) {
        super(User.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public List<AdminUsedCar> findAdminUsedCar() {
        List<AdminUsedCar> adminUsedCars =  queryFactory.select(Projections.fields(AdminUsedCar.class,
                electricCar.carName, user.name, user.userId, usedCar.price, usedCar.mileage))
                .from(usedCar)
                .innerJoin(user).on(user.userSeq.eq(usedCar.user.userSeq))
                .innerJoin(electricCar).on(electricCar.eccarId.eq(usedCar.electricCar.eccarId))
                .fetch();
        return adminUsedCars;
    }


}
