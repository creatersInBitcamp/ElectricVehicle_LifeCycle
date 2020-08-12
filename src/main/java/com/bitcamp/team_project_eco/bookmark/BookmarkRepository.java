package com.bitcamp.team_project_eco.bookmark;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookmarkRepository extends JpaRepository<Bookmark,Long>, CustomedBookmarkRepository {

}
