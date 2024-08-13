package com.example.restaurantmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurantmanagementsystem.entity.Waiter;

public interface WaiterRepository extends JpaRepository<Waiter, Long> {

}