package com.portal.productservice.converter;

import com.portal.productservice.payload.ProductRequest;
import com.portal.productservice.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductRequestConverter implements Converter<ProductRequest, Product> {

    @Override
    public Product convert(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
    }
}
