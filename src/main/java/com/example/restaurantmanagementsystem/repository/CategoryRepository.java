package com.example.restaurantmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurantmanagementsystem.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
