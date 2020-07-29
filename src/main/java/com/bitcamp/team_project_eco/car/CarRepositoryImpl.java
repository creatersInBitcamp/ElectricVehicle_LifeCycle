package com.bitcamp.team_project_eco.car;


import com.bitcamp.team_project_eco.comparison.Comparison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
interface CarRepository extends JpaRepository<Comparison,Long>, com.bitcamp.team_project_eco.car.CarService {

}

interface CarService {

}
public class CarRepositoryImpl extends QuerydslRepositorySupport implements com.bitcamp.team_project_eco.car.CarService {

    public CarRepositoryImpl() {
        super(Comparison.class);
    }
}


