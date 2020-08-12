package com.bitcamp.team_project_eco.purchase;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase,Long>, CustomedPurchaseRepository {
}
