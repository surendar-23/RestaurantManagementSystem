package com.example.restaurantmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurantmanagementsystem.entity.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

}