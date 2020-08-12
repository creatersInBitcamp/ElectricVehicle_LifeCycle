package com.bitcamp.team_project_eco.electriccar;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

interface CustomedECarRepository {}

public class ElectricCarRepositoryImpl extends QuerydslRepositorySupport implements CustomedECarRepository {
    private final JPAQueryFactory jpaQueryFactory;
    public ElectricCarRepositoryImpl(JPAQueryFactory jpaQueryFactory){
        super(ElectricCar.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }
}
