package com.bitcamp.team_project_eco.bookmark;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark,Integer>, CustomedBookmarkRepository {

}
