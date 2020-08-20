package com.bitcamp.team_project_eco.fare;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FareRepository extends JpaRepository<Fare, Long>, CustomedFareRepository {

    @Query("select e from Fare e where e.startName like %:startName% and  e.arriveName like %:arriveName%")
    List<Fare> findByStartNameAndArriveName(@Param("startName") String startName, @Param("arriveName") String arriveName);
}