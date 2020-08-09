package com.bitcamp.team_project_eco.comment;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

interface CustomedCommentRepository {}

@Repository
public class CommentRepositoryImpl extends QuerydslRepositorySupport implements CustomedCommentRepository{

    private JPAQueryFactory queryFactory;

    CommentRepositoryImpl(JPAQueryFactory queryFactory) {
        super(Comment.class);
        this.queryFactory = queryFactory;
    }

}
