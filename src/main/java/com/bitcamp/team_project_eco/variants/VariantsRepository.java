package com.bitcamp.team_project_eco.variants;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VariantsRepository extends JpaRepository<Variants,Long>, CustomedVariantsRepository {
}
