package com.bitcamp.team_project_eco.wishlist;

import com.bitcamp.team_project_eco.car.Car;
import com.bitcamp.team_project_eco.utils.JpaService;
import org.springframework.stereotype.Service;

import java.util.Optional;

interface WishlistService extends JpaService<Wishlist>{

    void insertWishlist(Wishlist wishlist);

    void updateWishlist(Wishlist wishlist);
}

@Service
public class WishlistServiceImpl implements WishlistService{
    private final WishlistRepository wishlistRepository;

    public WishlistServiceImpl(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    @Override
    public Optional<Wishlist> findById(String id) {
        return wishlistRepository.findById(Integer.parseInt(id));
    }

    @Override
    public Iterable<Wishlist> findAll() {
        return wishlistRepository.findAll();
    }

    @Override
    public int count() {
        return (int) wishlistRepository.count();
    }

    @Override
    public void delete(String id) {
        wishlistRepository.delete(findById(id).orElse(new Wishlist()));
    }

    @Override
    public boolean exists(String id) {
        return wishlistRepository.existsById(Integer.parseInt(id));
    }

    @Override
    public void insertWishlist(Wishlist wishlist) {
        wishlistRepository.save(wishlist);
    }

    @Override
    public void updateWishlist(Wishlist wishlist) {

    }
}
