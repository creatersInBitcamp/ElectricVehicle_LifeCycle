package com.bitcamp.team_project_eco.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Integer>, CustomedPostRepository {

    @Query("select e from Post e where e.category = :category")
    Page<Post> findByCategory(String category, Pageable pageable);

    @Query("select e from Post e where e.category = :category and e.title like %:title%")
    Page<Post> findByCategoryAndTitleLikeSearchWord(@Param("category") String category,
                                                    @Param("title")String title,
                                                    Pageable page);

    @Query("select e from Post e where e.category = :category and e.content like %:content%")
    Page<Post> findByCategoryAndContentLikeSearchWord(@Param("category") String category,
                                                      @Param("content")String content,
                                                      Pageable page);

    @Query("select e from Post e where e.category = :category and e.userId like %:userId%")
    Page<Post> findByCategoryAndUserIdLikeSearchWord(@Param("category") String category,
                                                     @Param("userId")String userId,
                                                     Pageable page);
}