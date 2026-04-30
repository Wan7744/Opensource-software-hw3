package com.example.restaurant_service.controller;

import com.example.restaurant_service.entity.Category;
import com.example.restaurant_service.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}