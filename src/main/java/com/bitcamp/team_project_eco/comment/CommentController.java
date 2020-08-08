package com.bitcamp.team_project_eco.comment;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController @AllArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    //create, read, update, delete
    private CommentService commentService;

    @GetMapping("/comment/{postId}")
    public List<Comment> findByPostId(@PathVariable String postId) {
        return commentService.findByPostId(postId);
    }

    @PostMapping("/insert")
    public void insertComment(Comment comment) {

    }
}
