package com.bitcamp.team_project_eco.wishlist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist,Integer>, CustomedWishlistRepository {
}
