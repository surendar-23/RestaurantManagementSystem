package com.restaurantmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurantmanagementsystem.entity.Waiter;

@Repository
public interface WaiterRepository extends JpaRepository<Waiter, Long> {
}
