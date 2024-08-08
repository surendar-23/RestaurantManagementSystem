package com.restaurantmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurantmanagementsystem.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
