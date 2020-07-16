package com.bitcamp.team_project_eco.board;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    // create, read, update, delete.
    @PostMapping("/create")
    public boolean createBoard(@RequestBody Board board){

        return false;
    }
    @GetMapping("/boardList")
    public List<Board> boardList(){
        return null;
    }
    @GetMapping("/read")
    public Board readBoard(@PathVariable Long boardNo){

        return null;
    }
    @PostMapping("/update")
    public boolean updateBoard(@RequestBody Board board){
        return false;
    }
    @PostMapping("/delete")
    public boolean deleteBoard(@RequestBody Board board){
        return false;
    }
}
