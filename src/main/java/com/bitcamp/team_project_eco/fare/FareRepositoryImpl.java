package com.bitcamp.team_project_eco.fare;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

interface CustomedFareRepository {}

@Repository
public class FareRepositoryImpl extends QuerydslRepositorySupport implements CustomedFareRepository{
    private final JPAQueryFactory jpaQueryFactory;
    public FareRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(Fare.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }
}
