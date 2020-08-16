package com.bitcamp.team_project_eco.variants;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

interface CustomedVariantsRepository{}

@Repository
public class VariantsRepositoryImpl extends QuerydslRepositorySupport implements CustomedVariantsRepository {
    private final JPAQueryFactory jpaQueryFactory;
    public VariantsRepositoryImpl(JPAQueryFactory jpaQueryFactory){
        super(Variants.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }
}
