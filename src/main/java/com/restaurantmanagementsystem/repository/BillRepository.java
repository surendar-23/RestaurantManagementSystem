package com.restaurantmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurantmanagementsystem.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
}
