package com.bitcamp.team_project_eco.wishlist;

import com.bitcamp.team_project_eco.car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/wishlists")
public class WishlistController {
    @Autowired WishlistService wishlistService;

    @GetMapping("/getall")
    public List<Wishlist> getAllWishlist(){
        return (List<Wishlist>) wishlistService.findAll();
    }

    @GetMapping("/getone/{wishlistId}")
    public Optional<Wishlist> getOneWishlist(@PathVariable String wishlistId) {
        return wishlistService.findById(wishlistId);
    }

    @PostMapping("/insert")
    public void insertWishlist(@RequestBody Wishlist wishlist) {
        wishlistService.insertWishlist(wishlist);
    }
    @PostMapping("/update")
    public void updateWishlist(@RequestBody Wishlist wishlist) {
        wishlistService.updateWishlist(wishlist);
    }

    @GetMapping("/delete")
    public void deleteWishlist(@PathVariable String wishlistId) {
        wishlistService.delete(wishlistId);
    }
}
