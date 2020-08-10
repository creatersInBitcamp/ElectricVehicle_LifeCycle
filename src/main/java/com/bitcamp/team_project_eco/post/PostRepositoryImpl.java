package com.bitcamp.team_project_eco.post;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

interface CustomedPostRepository {

}

@Repository
public class PostRepositoryImpl extends QuerydslRepositorySupport implements CustomedPostRepository{

    private final JPAQueryFactory jpaQueryFactory;
    public PostRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(Post.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }
}
