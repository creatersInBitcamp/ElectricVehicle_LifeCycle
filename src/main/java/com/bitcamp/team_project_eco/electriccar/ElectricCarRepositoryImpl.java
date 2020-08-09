package com.bitcamp.team_project_eco.electriccar;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

interface CustomedECarRepository {}

public class ElectricCarRepositoryImpl extends QuerydslRepositorySupport implements CustomedECarRepository {
    /**
     * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
     *
     * @param domainClass must not be {@literal null}.
     */
    private final JPAQueryFactory jpaQueryFactory;
    public ElectricCarRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(ElectricCar.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }
}
