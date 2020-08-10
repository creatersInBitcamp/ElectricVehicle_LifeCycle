package com.bitcamp.team_project_eco.bookmark;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

interface CustomedBookmarkRepository{

}
@Repository
public class BookmarkRepositoryImpl extends QuerydslRepositorySupport implements CustomedBookmarkRepository{

    private final JPAQueryFactory jpaQueryFactory;
    public BookmarkRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(Bookmark.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }
}
