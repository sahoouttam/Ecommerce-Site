package com.portal.wishlistservice.service;

import com.portal.wishlistservice.dto.WishlistDto;
import com.portal.wishlistservice.entity.Wishlist;
import com.portal.wishlistservice.payload.WishlistRequest;

import java.util.List;

public interface WishlistService {


    void createWishlist(WishlistRequest wishlistRequest);

    List<WishlistDto> getAllWishlist();

    WishlistDto getWishlistById(Long id);

    void updateWishlist(WishlistRequest wishlistRequest, Long id);

    void deleteWishlistById(Long id);


}
