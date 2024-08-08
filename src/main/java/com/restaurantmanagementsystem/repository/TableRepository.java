package com.restaurantmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurantmanagementsystem.entity.Table;

@Repository
public interface TableRepository extends JpaRepository<Table, Long> {
}
