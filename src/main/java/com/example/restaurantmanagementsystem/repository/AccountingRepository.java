package com.example.restaurantmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restaurantmanagementsystem.entity.Accounting;

@Repository
public interface AccountingRepository extends JpaRepository<Accounting, Long> {
}
