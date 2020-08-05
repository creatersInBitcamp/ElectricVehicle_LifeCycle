package com.bitcamp.team_project_eco.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/boards")
public class BoardController {
    // create, read, update, delete.
    @Autowired BoardRepository boardRepository;

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
