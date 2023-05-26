package com.portal.wishlistservice.mapper;

import com.portal.wishlistservice.dto.ProductDto;
import com.portal.wishlistservice.dto.WishlistDto;
import com.portal.wishlistservice.entity.Wishlist;
import com.portal.wishlistservice.payload.WishlistRequest;

public class Mapper {

    private Mapper() {}

    public static WishlistDto convertWishlist(Wishlist wishlist) {
        return WishlistDto.builder()
                .productId(wishlist.getProductId())
                .createdDate(wishlist.getCreatedDate())
                .productDto(ProductDto.builder()
                        .id(wishlist.getProductId())
                        .build())
                .build();
    }

    public static Wishlist convertWishlistDto(WishlistRequest wishlistRequest) {
        return Wishlist.builder()
                .productId(wishlistRequest.getProductId())
                .createdDate(wishlistRequest.getCreatedDate())
                .build();
    }

    public static Wishlist updateWishlist(Wishlist wishlist, WishlistRequest wishlistRequest) {
        wishlist.setProductId(wishlistRequest.getProductId());
        wishlist.setCreatedDate(wishlistRequest.getCreatedDate());
        return wishlist;
    }
}
