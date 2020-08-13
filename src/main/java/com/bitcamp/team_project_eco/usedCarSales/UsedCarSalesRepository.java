package com.bitcamp.team_project_eco.usedCarSales;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsedCarSalesRepository extends JpaRepository<UsedCarSales,Long>, IUsedCarSalesRepository {
}