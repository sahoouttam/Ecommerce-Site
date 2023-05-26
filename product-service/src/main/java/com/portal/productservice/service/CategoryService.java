package com.portal.productservice.service;

import com.portal.productservice.constant.Constants;
import com.portal.productservice.converter.CategoryConverter;
import com.portal.productservice.converter.CategoryRequestConverter;
import com.portal.productservice.entity.Category;
import com.portal.productservice.exception.ResourceNotFoundException;
import com.portal.productservice.payload.CategoryRequest;
import com.portal.productservice.payload.CategoryResponse;
import com.portal.productservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryRequestConverter categoryRequestConverter;

    private final CategoryConverter categoryConverter;

    public ResponseEntity<HttpStatus> createCategory(CategoryRequest categoryRequest) {
        Category category = categoryRequestConverter.convert(categoryRequest);
        if (category == null) throw new ResourceNotFoundException(Constants.CATEGORY_NOT_FOUND);
        categoryRepository.save(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        List<CategoryResponse> categories = categoryRepository.findAll()
                .stream()
                .map(categoryConverter::convert)
                .collect(Collectors.toList());

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
