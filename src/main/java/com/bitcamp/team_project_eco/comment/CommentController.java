package com.bitcamp.team_project_eco.comment;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/comments")
public class CommentController {
    //create, read, update, delete
    @Autowired CommentService commentService;

//    @GetMapping("/getAll/{postId}")
//    public List<Comment> findAllByPostId(@PathVariable String postId){
//        Long pi = Long.parseLong(postId);
//        return commentService.findAllByPostId(pi);
//    }

    @PostMapping("/insert")
    public void insertCommentByPostId(@RequestBody NewCommentVO comment){
        commentService.insertComment(comment);
    }

    @PostMapping("/delete/")
    public void deleteComment(@RequestBody NewCommentVO comment) {
        System.out.println(comment.getUser());
        System.out.println(comment.getPost());
//        commentService.deleteComment(comment);
        commentService.delete(comment.commentId);
    }
}
