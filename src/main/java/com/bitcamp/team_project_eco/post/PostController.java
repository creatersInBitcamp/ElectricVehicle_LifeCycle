package com.bitcamp.team_project_eco.post;

import com.bitcamp.team_project_eco.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @GetMapping("/pageall/{page}")
    public Page<Post> postList(@PathVariable int page) {
       return service.pagingFindAll(PageRequest.of(page-1, 5));
    }
    @GetMapping("/pages/{category}/{page}")
    public Page<Post> allPostByCate(@PathVariable int page, @PathVariable String category) {
        return service.allPostFindByCategory(category, PageRequest.of(page-1, 5));
    }

    @GetMapping("/popular")
    public Page<Post> popularList() {
        return service.popularSort(PageRequest.of(0, 5, Sort.by(Sort.Order.desc("hits"))));
    }

    @GetMapping("/recent")
    public Page<Post> recentList() {
        return service.recentSort(PageRequest.of(0, 5, Sort.by(Sort.Order.desc("post_id"))));
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
    public void insertPost(@RequestBody NewPostVO newPost) {
        service.insertPost(newPost);
    }

    @PostMapping("/update")
    public void updatePost(@RequestBody Post post) {
        service.updatePost(post);
    }

    @GetMapping("/delete/{postId}")
    public void deletePost(@PathVariable String postId) {
        service.delete(postId);
    }

}
