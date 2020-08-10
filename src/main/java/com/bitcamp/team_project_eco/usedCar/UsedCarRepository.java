package com.bitcamp.team_project_eco.usedCar;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsedCarRepository extends JpaRepository<UsedCar,Long>, IUsedCarRepository {

}
