package com.bitcamp.team_project_eco.newCar.comparison;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

interface ComparisonRepository extends JpaRepository<Comparison,Long>,ComparisonService{}

interface ComparisonService {

}
public class ComparisonRepositoryImpl extends QuerydslRepositorySupport implements ComparisonService {

    public ComparisonRepositoryImpl() {
        super(Comparison.class);
    }
}
