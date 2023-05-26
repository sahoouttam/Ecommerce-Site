package com.portal.wishlistservice.controller;

import com.portal.wishlistservice.dto.WishlistDto;
import com.portal.wishlistservice.payload.WishlistRequest;
import com.portal.wishlistservice.service.WishlistServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class WishlistController {

    private WishlistServiceImpl wishlistService;

    @PostMapping("/wishlist")
    public ResponseEntity<HttpStatus> createWishlist(@RequestBody WishlistRequest wishlistRequest) {
        wishlistService.createWishlist(wishlistRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/wishlist")
    public ResponseEntity<List<WishlistDto>> getAllWishList() {
        return new ResponseEntity<>(wishlistService.getAllWishlist(), HttpStatus.OK);
    }

    @PutMapping("/wishlist/{id}")
    public ResponseEntity<HttpStatus> updateWishlist(@RequestBody WishlistRequest wishlistRequest, @PathVariable Long id) {
        wishlistService.updateWishlist(wishlistRequest, id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/wishlist/{id}")
    public ResponseEntity<HttpStatus> deleteWishlistById(@PathVariable Long id) {
        wishlistService.deleteWishlistById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
