package com.bitcamp.team_project_eco.comment;

import com.bitcamp.team_project_eco.utils.JpaService;
import org.springframework.stereotype.Service;

import java.util.Optional;

interface CommentService extends JpaService<Comment> {

}

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository repository;

    public CommentServiceImpl(CommentRepository repository) {
        this.repository = repository;
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
}
