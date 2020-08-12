package com.bitcamp.team_project_eco.chargingStation;

import com.bitcamp.team_project_eco.car.CarRepositoryImpl;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

interface CustomedChargingStationRepository{

}

@Repository
public class ChargingStationRepositoryImpl extends QuerydslRepositorySupport implements CustomedChargingStationRepository{
    private final JPAQueryFactory jpaQueryFactory;
    public ChargingStationRepositoryImpl(JPAQueryFactory jpaQueryFactory){
        super(ChargingStation.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }
}
