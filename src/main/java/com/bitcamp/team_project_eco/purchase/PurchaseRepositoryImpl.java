package com.bitcamp.team_project_eco.purchase;

import com.bitcamp.team_project_eco.electriccar.ElectricCar;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

interface CustomedPurchaseRepository{

}
@Repository
public class PurchaseRepositoryImpl extends QuerydslRepositorySupport implements CustomedPurchaseRepository{
    final JPAQueryFactory jpaQueryFactory;
    public PurchaseRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(Purchase.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }
}
