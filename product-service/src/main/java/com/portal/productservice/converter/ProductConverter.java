package com.portal.productservice.converter;

import com.portal.productservice.payload.ProductResponse;
import com.portal.productservice.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductConverter implements Converter<Product, ProductResponse> {

    @Override
    public ProductResponse convert(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .brand(product.getBrand())
                .build();
    }
}
