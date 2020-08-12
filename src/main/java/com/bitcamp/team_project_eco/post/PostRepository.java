package com.bitcamp.team_project_eco.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import javax.persistence.QueryHint;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer>, CustomedPostRepository {

//    List<Post> findByCategory(String category);
    @Query("select e from Post e where e.category = :category")
    Page<Post> findByCategory(String category, Pageable pageable);
}