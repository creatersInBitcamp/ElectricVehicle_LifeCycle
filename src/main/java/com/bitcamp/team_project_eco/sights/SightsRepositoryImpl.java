package com.bitcamp.team_project_eco.sights;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

interface CustomedSightsRepository{

}

@Repository
public class SightsRepositoryImpl extends QuerydslRepositorySupport implements CustomedSightsRepository {
    private final JPAQueryFactory jpaQueryFactory;
    public SightsRepositoryImpl(JPAQueryFactory jpaQueryFactory){
        super(Sights.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }
}
