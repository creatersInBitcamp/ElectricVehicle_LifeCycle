package com.bitcamp.team_project_eco.car;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long>, CustomedCarRepository {


}
