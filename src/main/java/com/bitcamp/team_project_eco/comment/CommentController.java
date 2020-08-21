package com.bitcamp.team_project_eco.comment;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/comments")
public class CommentController {
    //create, read, update, delete
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/insert")
    public void insertCommentByPostId(@RequestBody NewCommentVO comment){
        commentService.insertComment(comment);
    }

    @GetMapping("/delete/{commentId}")
    public void deleteComment(@PathVariable String commentId) {
        commentService.delete(commentId);
    }
}
