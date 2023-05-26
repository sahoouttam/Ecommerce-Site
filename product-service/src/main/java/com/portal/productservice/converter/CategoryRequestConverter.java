package com.portal.productservice.converter;

import com.portal.productservice.entity.Category;
import com.portal.productservice.payload.CategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CategoryRequestConverter implements Converter<CategoryRequest, Category> {

    @Override
    public Category convert(CategoryRequest categoryRequest) {
        return Category.builder()
                .name(categoryRequest.getName())
                .products(categoryRequest.getProducts())
                .build();
    }
}
