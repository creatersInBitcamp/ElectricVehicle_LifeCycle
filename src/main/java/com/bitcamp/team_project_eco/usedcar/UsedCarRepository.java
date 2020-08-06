package com.bitcamp.team_project_eco.usedcar;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsedCarRepository extends JpaRepository<UsedCar,Long>, IUsedCarRepository {
}
