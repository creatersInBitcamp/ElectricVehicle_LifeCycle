package com.bitcamp.team_project_eco.chargingStation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargingStationRepository extends JpaRepository<ChargingStation,Integer>, CustomedChargingStationRepository {
}
