package com.portal.productservice.controller;

import com.portal.productservice.entity.Product;
import com.portal.productservice.payload.ProductRequest;
import com.portal.productservice.payload.ProductResponse;
import com.portal.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<HttpStatus> createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable long id) {
        return productService.getProductById(id);
    }


}
