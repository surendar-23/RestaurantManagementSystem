package com.restaurantmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurantmanagementsystem.entity.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
