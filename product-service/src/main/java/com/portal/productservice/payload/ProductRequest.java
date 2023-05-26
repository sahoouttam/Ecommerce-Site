package com.portal.productservice.payload;

import com.portal.productservice.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    private String name;

    private String description;

    private String brand;


    private double price;

    private List<Category> categories;
}
