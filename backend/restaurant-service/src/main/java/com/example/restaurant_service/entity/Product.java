package com.example.restaurant_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    private String name;

    private int price;

    @Column(name = "image_url")
    private String imageUrl;

    private String keyword;

    private String description;

    @Column(name = "is_available")
    private int isAvailable;
}