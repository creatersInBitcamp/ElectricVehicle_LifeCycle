package com.bitcamp.team_project_eco.repositories;

import com.bitcamp.team_project_eco.entities.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
