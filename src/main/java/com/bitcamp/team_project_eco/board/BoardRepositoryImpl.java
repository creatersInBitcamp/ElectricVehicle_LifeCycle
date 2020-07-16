package com.bitcamp.team_project_eco.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

interface BoardService { }
interface BoardRepository extends JpaRepository<Board, Long>, BoardService { }

public class BoardRepositoryImpl extends QuerydslRepositorySupport implements BoardService {

    BoardRepositoryImpl() { super(Board.class); }
}
