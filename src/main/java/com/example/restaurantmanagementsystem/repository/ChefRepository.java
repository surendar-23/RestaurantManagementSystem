package com.example.restaurantmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurantmanagementsystem.entity.Chef;

public interface ChefRepository extends JpaRepository<Chef, Long> {

}