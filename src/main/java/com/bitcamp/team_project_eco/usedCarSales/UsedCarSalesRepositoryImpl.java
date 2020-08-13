package com.bitcamp.team_project_eco.usedCarSales;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

interface IUsedCarSalesRepository {

}

@Repository
public class UsedCarSalesRepositoryImpl extends QuerydslRepositorySupport implements IUsedCarSalesRepository {

    /**
     * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
     *
     * @param domainClass must not be {@literal null}.
     */

    private final JPAQueryFactory queryFactory;

    public UsedCarSalesRepositoryImpl(JPAQueryFactory queryFactory) {
        super(UsedCarSales.class);
        this.queryFactory = queryFactory;
    }
}
