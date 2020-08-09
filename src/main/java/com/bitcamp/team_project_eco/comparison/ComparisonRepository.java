package com.bitcamp.team_project_eco.comparison;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComparisonRepository extends JpaRepository<Comparison, Long>, CustomedComparisonRepository { }
