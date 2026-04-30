package com.example.restaurant_service.repository;

import com.example.restaurant_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryId(Long categoryId);

    List<Product> findByKeywordContaining(String keyword);
}