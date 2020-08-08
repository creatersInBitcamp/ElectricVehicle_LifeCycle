package com.bitcamp.team_project_eco.comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer>, CustomedCommentRepository {
}
