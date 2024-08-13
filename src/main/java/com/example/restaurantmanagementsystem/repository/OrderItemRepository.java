package com.example.restaurantmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurantmanagementsystem.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
