package com.bitcamp.team_project_eco.electriccar;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

interface ElectricCarRepository extends JpaRepository<ElectricCar,Long>,ElectricService{}

interface ElectricService {}


public class ElectricCarRepositoryImpl extends QuerydslRepositorySupport implements ElectricService {

    public ElectricCarRepositoryImpl() {
        super(ElectricCar.class);
    }
}
