package com.portal.productservice.service;

import com.portal.productservice.constant.Constants;
import com.portal.productservice.converter.ProductConverter;
import com.portal.productservice.converter.ProductRequestConverter;
import com.portal.productservice.entity.Product;
import com.portal.productservice.exception.ResourceNotFoundException;
import com.portal.productservice.payload.ProductRequest;
import com.portal.productservice.payload.ProductResponse;
import com.portal.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductRequestConverter productRequestConverter;

    private final ProductConverter productConverter;

    public ResponseEntity<HttpStatus> createProduct(ProductRequest productRequest) {
        Product product = productRequestConverter.convert(productRequest);
        if (product == null) throw new ResourceNotFoundException(Constants.PRODUCT_NOT_FOUND);
        productRepository.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<ProductResponse> getProductById(long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constants.PRODUCT_NOT_FOUND));
        return new ResponseEntity<>(productConverter.convert(product), HttpStatus.OK);
    }

    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> products = productRepository
                .findAll()
                .stream()
                .map(productConverter::convert)
                .collect(Collectors.toList());

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    public ResponseEntity<List<ProductResponse>> getAllProductsByBrand(String brand) {
        List<ProductResponse> products = productRepository
                .findByBrand(brand)
                .stream()
                .map(productConverter::convert)
                .collect(Collectors.toList());

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    public ResponseEntity<List<ProductResponse>> getAllProductsByPriceBetween(double minPrice, double maxPrice) {
        List<ProductResponse> products = productRepository
                .findByPriceBetween(minPrice, maxPrice)
                .stream()
                .map(productConverter::convert)
                .collect(Collectors.toList());

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
