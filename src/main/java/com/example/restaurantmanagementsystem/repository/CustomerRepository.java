package com.example.restaurantmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurantmanagementsystem.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
