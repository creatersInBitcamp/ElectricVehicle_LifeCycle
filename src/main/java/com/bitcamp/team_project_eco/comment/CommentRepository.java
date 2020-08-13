package com.bitcamp.team_project_eco.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>, CustomedCommentRepository {
    @Query("select e from Comment e")
    List<Comment> findAllComment();
}
