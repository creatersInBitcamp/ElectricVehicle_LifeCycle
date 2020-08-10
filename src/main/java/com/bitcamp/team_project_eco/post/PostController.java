package com.bitcamp.team_project_eco.post;

import com.bitcamp.team_project_eco.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/posts")
public class PostController {
    // create, read, update, delete.
    @Autowired PostService service;

    @GetMapping("/readcsv")
    public void csvRead(){
        service.readCsv();
    }

    @GetMapping("/getall")
    public List<Post> getAllPost(){
        return (List<Post>) service.findAll();
    }

    @GetMapping("/getone/{postId}")
    public Optional<Post> getOnePost(@PathVariable String postId) {
        return service.findById(postId);
    }

    @PostMapping("/insert")
    public void insertPost(@RequestBody Post post) {
        service.insertPost(post);
    }
    @PostMapping("/update")
    public void updatePost(@RequestBody Post post) {
        service.updatePost(post);
    }

    @GetMapping("/delete")
    public void deletePost(@PathVariable String postId) {
        service.delete(postId);
    }

}
