package com.bitcamp.team_project_eco.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/posts")
public class PostController {
    // create, read, update, delete.
    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/readcsv")
    public void csvRead(){
        service.readCsv();
    }

    @GetMapping("/pages/{category}/{page}")
    public Page<Post> allPostByCate(@PathVariable int page, @PathVariable String category) {
        return service.allPostFindByCategory(category, page);
    }

    @GetMapping("/notice/{category}")
    public List<Post> noticeAll(@PathVariable String category) {
        return service.findByCategory(category);
    }

    @GetMapping("/popular")
    public Page<Post> popularList() {
        return service.popularSort();
    }

    @GetMapping("/recent")
    public Page<Post> recentList() {
        return service.recentSort();
    }

    @GetMapping("/getall")
    public Iterable<Post> getAllPost(){
        return service.findAll();
    }

    @GetMapping("/getOne/{postId}")
    public Optional<Post> getOnePost(@PathVariable String postId) {
        return service.getOneById(postId);
    }

    @PostMapping("/insert")
    public void insertPost(@RequestBody NewPostVO newPost) {
        System.out.println(newPost.toString());
        service.insertPost(newPost);
    }

    @PostMapping("/update")
    public void updatePost(@RequestBody NewPostVO upPost) {
        service.updatePost(upPost);
    }

    @GetMapping("/delete/{postId}")
    public void deletePost(@PathVariable String postId) {
        service.delete(postId);
    }

    @GetMapping("/search/{category}/{condition}/{searchWord}/{page}")
    public Page<Post> searchPosts(@PathVariable String category,
                                  @PathVariable String condition,
                                  @PathVariable String searchWord,
                                  @PathVariable int page){
        return service.findBySearchWord(category, condition, searchWord, PageRequest.of(page-1, 5));
    }

    @GetMapping("/recommend/{postId}")
    public boolean recommend(@PathVariable Long postId) {
        return service.recommend(postId);
    }

    @GetMapping("/report/{postId}")
    public boolean report(@PathVariable Long postId) {
        return service.report(postId);
    }
}
