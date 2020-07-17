package com.bitcamp.team_project_eco.insurance;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

interface InsuranceRepository extends JpaRepository<Insurance,Long>,InsuranceService {}

interface InsuranceService {}


public class InsuranceRepositoryImpl extends QuerydslRepositorySupport implements InsuranceService {

    public InsuranceRepositoryImpl() {
        super(Insurance.class);
    }
}
