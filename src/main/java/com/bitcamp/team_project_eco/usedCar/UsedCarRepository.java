package com.bitcamp.team_project_eco.usedCar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsedCarRepository extends JpaRepository<UsedCar,Long>, IUsedCarRepository {
}
