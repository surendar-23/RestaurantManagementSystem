package com.example.restaurantmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurantmanagementsystem.entity.Table;

public interface TableRepository extends JpaRepository<Table, Long> {

}