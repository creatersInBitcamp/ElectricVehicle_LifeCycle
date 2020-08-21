package com.bitcamp.team_project_eco.electriccar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ElectricCarRepository extends JpaRepository<ElectricCar, Long>, CustomedECarRepository {
    @Query("select e from ElectricCar e where e.carName like %:searchWord%")
    List<ElectricCar> findAllByCarName(@Param("searchWord") String searchWord);
}
