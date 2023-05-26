package com.portal.productservice.controller;

import com.portal.productservice.payload.CategoryRequest;
import com.portal.productservice.payload.CategoryResponse;
import com.portal.productservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CategoryController {

    @Autowired
    private final CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<HttpStatus> createCategory(@RequestBody CategoryRequest categoryRequest) {
        return categoryService.createCategory(categoryRequest);
    }

    @GetMapping("/category")
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
