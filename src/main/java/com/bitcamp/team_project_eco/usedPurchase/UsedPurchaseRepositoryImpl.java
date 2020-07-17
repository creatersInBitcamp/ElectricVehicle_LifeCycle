package com.bitcamp.team_project_eco.usedPurchase;

import com.bitcamp.team_project_eco.newCar.ElectricCar;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
interface UsedPurchaseRepository extends JpaRepository<ElectricCar,Long>, UsedPurchaseService { }

interface UsedPurchaseService { }

public class UsedPurchaseRepositoryImpl extends QuerydslRepositorySupport implements UsedPurchaseService {

    UsedPurchaseRepositoryImpl() { super(ElectricCar.class); }

    @Autowired JPAQueryFactory queryFactory;
}
