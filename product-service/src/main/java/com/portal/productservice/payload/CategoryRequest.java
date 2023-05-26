package com.portal.productservice.payload;

import com.portal.productservice.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {

    private String name;

    private List<Product> products;
}
