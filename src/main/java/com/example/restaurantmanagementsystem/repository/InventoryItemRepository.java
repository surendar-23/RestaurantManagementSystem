package com.example.restaurantmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurantmanagementsystem.entity.InventoryItem;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

}