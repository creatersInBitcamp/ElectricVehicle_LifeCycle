package com.bitcamp.team_project_eco.image;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,Long>, CustomedImageRepository {
}
