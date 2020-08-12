package com.bitcamp.team_project_eco.wishlist;

import com.bitcamp.team_project_eco.car.Car;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

interface CustomedWishlistRepository{

}

@Repository
public class WishlistRepositoryImpl extends QuerydslRepositorySupport implements CustomedWishlistRepository{

    private final JPAQueryFactory jpaQueryFactory;
    public WishlistRepositoryImpl(JPAQueryFactory jpaQueryFactory){
        super(Wishlist.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }
}
