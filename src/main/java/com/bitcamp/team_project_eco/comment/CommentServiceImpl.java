package com.bitcamp.team_project_eco.comment;

import com.bitcamp.team_project_eco.post.Post;
import com.bitcamp.team_project_eco.post.PostRepository;
import com.bitcamp.team_project_eco.user.User;
import com.bitcamp.team_project_eco.user.UserRepository;
import com.bitcamp.team_project_eco.utils.JpaService;
import org.springframework.stereotype.Service;

import java.util.Optional;

interface CommentService extends JpaService<Comment> {

    void insertComment(NewCommentVO comment);
}

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository repository;
    private final UserRepository ur;
    private final PostRepository pr;

    public CommentServiceImpl(CommentRepository repository, UserRepository ur, PostRepository pr) {
        this.repository = repository;
        this.ur = ur;
        this.pr = pr;
    }

    @Override
    public Optional<Comment> findById(String id) {
        return repository.findById(Integer.parseInt(id));
    }

    @Override
    public Iterable<Comment> findAll() {
        return repository.findAll();
    }

    @Override
    public int count() {
        return (int) repository.count();
    }

    @Override
    public void delete(String id) {
        repository.delete(findById(id).orElse(new Comment()));
    }

    @Override
    public boolean exists(String id) {
        return repository.existsById(Integer.parseInt(id));
    }

    @Override
    public void insertComment(NewCommentVO comment) {
        User u = ur.findById(comment.user.getUserSeq()).get();
        Post p = pr.findById(comment.post.getPostId()).get();
        repository.save(new Comment(comment.regDate, comment.comment, u, p));
    }
}
