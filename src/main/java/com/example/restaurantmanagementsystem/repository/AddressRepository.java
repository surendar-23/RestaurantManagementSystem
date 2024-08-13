package com.example.restaurantmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurantmanagementsystem.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}