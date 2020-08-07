package com.bitcamp.team_project_eco.sights;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
interface SightsRepository extends JpaRepository<Sights,Long>, SightsService{}
interface SightsService{}
public class SightsRepositoryImpl extends QuerydslRepositorySupport implements SightsService {
    SightsRepositoryImpl(){
        super(Sights.class);
    }
}
