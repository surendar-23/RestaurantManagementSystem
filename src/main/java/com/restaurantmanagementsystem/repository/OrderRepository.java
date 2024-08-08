package com.restaurantmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurantmanagementsystem.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
