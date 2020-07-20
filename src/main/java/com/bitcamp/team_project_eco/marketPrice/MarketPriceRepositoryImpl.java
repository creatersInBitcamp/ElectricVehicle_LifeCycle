package com.bitcamp.team_project_eco.marketPrice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
interface MarketPriceRepository extends JpaRepository<MarketPrice, Long>, MarketPriceService { }

interface MarketPriceService { }

public class MarketPriceRepositoryImpl extends QuerydslRepositorySupport implements MarketPriceService {
    MarketPriceRepositoryImpl(){
        super(MarketPrice.class);
    }
}
