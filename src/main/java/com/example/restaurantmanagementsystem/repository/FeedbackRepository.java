package com.example.restaurantmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurantmanagementsystem.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}