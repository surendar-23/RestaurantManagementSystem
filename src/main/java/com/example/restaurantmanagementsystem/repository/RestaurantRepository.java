package com.example.restaurantmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurantmanagementsystem.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
