package com.bitcamp.team_project_eco.usedCar;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

interface IUsedCarRepository {

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
}
