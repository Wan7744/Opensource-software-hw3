package com.example.restaurant_service.controller;

import com.example.restaurant_service.entity.Product;
import com.example.restaurant_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> getProductsByCategory(@PathVariable Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String keyword) {
        return productRepository.findByKeywordContaining(keyword);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}