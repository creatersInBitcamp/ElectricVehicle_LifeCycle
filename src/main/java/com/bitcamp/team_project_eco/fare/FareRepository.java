package com.bitcamp.team_project_eco.fare;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FareRepository extends JpaRepository<Fare, Long>, CustomedFareRepository {

}
