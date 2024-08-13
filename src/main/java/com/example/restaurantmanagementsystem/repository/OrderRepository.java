package com.example.restaurantmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurantmanagementsystem.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
