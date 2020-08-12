package com.bitcamp.team_project_eco.car;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

interface CustomedCarRepository {}

@Repository
public class CarRepositoryImpl extends QuerydslRepositorySupport implements CustomedCarRepository {

    private final JPAQueryFactory jpaQueryFactory;
    public CarRepositoryImpl(JPAQueryFactory jpaQueryFactory){
        super(Car.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }
}
