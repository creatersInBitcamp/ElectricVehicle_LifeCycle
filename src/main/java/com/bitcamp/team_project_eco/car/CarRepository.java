package com.bitcamp.team_project_eco.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long>, CustomedCarRepository {

    @Query("select e from Car e where e.carName like %:searchWord% or e.brand like %:searchWord%")
    List<Car> findByCarNameOrBrand(@Param("searchWord") String searchWord);
}
