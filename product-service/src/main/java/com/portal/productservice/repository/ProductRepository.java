package com.portal.productservice.repository;

import com.portal.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByBrand(@Param("brand") String brand);

    List<Product> findByPriceBetween(@Param("price") double minPrice, @Param("price") double maxPrice);


}
