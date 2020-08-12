package com.bitcamp.team_project_eco.sights;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SightsRepository extends JpaRepository<Sights,Long>, CustomedSightsRepository{

}

