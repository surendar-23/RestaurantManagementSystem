package com.restaurantmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurantmanagementsystem.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
