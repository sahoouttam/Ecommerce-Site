package com.portal.wishlistservice.service;

import com.portal.wishlistservice.dto.ProductDto;
import com.portal.wishlistservice.dto.WishlistDto;
import com.portal.wishlistservice.entity.Wishlist;
import com.portal.wishlistservice.exception.ResourceNotFoundException;
import com.portal.wishlistservice.mapper.Mapper;
import com.portal.wishlistservice.payload.WishlistRequest;
import com.portal.wishlistservice.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class WishlistServiceImpl implements WishlistService {

    private final WishlistRepository wishlistRepository;
    private final RestTemplate restTemplate;

    @Override
    public void createWishlist(WishlistRequest wishlistRequest) {
        wishlistRepository.save(Mapper.convertWishlistDto(wishlistRequest));
    }

    @Override
    public List<WishlistDto> getAllWishlist() {
        return wishlistRepository.findAll().stream()
                .map(Mapper::convertWishlist)
                .peek(wishlistDto -> wishlistDto.setProductDto(restTemplate.getForEntity(
                        "http://PRODUCT-SERVICE/product-service/api/v1/product" + "/" + wishlistDto.getProductId(),
                        ProductDto.class).getBody()))
                .collect(Collectors.toList());
    }

    @Override
    public WishlistDto getWishlistById(Long id) {
        return wishlistRepository.findById(id)
                .map(Mapper::convertWishlist)
                .map(wishlistDto -> {wishlistDto.setProductDto(restTemplate.getForEntity(
                        "http://PRODUCT-SERVICE/product-service/api/v1/product" + "/" + wishlistDto.getProductId(),
                        ProductDto.class).getBody());
                    return wishlistDto;})
                .orElseThrow(() -> new ResourceNotFoundException("Wishlist not found with id " + id));

    }

    @Override
    public void updateWishlist(WishlistRequest wishlistRequest, Long id) {
        Wishlist wishlist = wishlistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Wish not found with id " + id));

        wishlistRepository.save(Mapper.updateWishlist(wishlist, wishlistRequest));

    }

    @Override
    public void deleteWishlistById(Long id) {
        wishlistRepository.deleteById(id);
    }
}
