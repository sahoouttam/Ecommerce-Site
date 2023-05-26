package com.portal.productservice.converter;

import com.portal.productservice.entity.Category;
import com.portal.productservice.payload.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryConverter implements Converter<Category, CategoryResponse> {

    @Override
    public CategoryResponse convert(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
