package com.example.restaurantmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurantmanagementsystem.entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

}