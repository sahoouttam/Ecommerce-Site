package com.portal.wishlistservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private long id;

    private String name;

    private String description;

    private String brand;

    private double price;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<WishlistDto> wishlistDtos;

}
