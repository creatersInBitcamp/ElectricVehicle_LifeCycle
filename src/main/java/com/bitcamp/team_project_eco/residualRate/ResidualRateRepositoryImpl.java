package com.bitcamp.team_project_eco.residualRate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
interface ResidualRateRepository extends JpaRepository<ResidualRate, Long>, ResidualRateService { }

interface ResidualRateService { }

public class ResidualRateRepositoryImpl extends QuerydslRepositorySupport implements ResidualRateService {
    ResidualRateRepositoryImpl(){
        super(ResidualRate.class);
    }
}
