package com.portal.wishlistservice.repository;

import com.portal.wishlistservice.entity.Wishlist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends MongoRepository<Wishlist, Long> {
}
