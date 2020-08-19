package com.bitcamp.team_project_eco.chargingStation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChargingStationRepository extends JpaRepository<ChargingStation,Long>, CustomedChargingStationRepository {
}
