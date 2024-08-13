package com.example.restaurantmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurantmanagementsystem.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {

}