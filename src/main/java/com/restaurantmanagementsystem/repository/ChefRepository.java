package com.restaurantmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurantmanagementsystem.entity.Chef;

@Repository
public interface ChefRepository extends JpaRepository<Chef, Long> {
}
