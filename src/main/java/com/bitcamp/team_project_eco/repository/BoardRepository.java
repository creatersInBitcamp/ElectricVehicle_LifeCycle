package com.bitcamp.team_project_eco.repository;

import com.bitcamp.team_project_eco.entities.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BoardRepository extends JpaRepository<Board, Long> {
}
