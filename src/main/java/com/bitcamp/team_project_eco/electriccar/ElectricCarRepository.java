package com.bitcamp.team_project_eco.electriccar;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectricCarRepository extends JpaRepository<ElectricCar, Long>, CustomedECarRepository {
}
