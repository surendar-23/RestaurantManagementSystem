package com.example.restaurantmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurantmanagementsystem.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}