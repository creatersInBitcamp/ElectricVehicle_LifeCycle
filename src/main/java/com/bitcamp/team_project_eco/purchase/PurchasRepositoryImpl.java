package com.bitcamp.team_project_eco.purchase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

interface PurchasRepository extends JpaRepository<Purchas,Long>,PurchasService{}

interface PurchasService{}

public class PurchasRepositoryImpl extends QuerydslRepositorySupport implements PurchasService {

    public PurchasRepositoryImpl() {
        super(Purchas.class);
    }
}
