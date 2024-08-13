package com.example.restaurantmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurantmanagementsystem.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
