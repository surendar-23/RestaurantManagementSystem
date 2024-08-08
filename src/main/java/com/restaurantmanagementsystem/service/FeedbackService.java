package com.restaurantmanagementsystem.service;

import java.util.List;

import com.restaurantmanagementsystem.entity.Feedback;

public interface FeedbackService {
	List<Feedback> getAllFeedbacks();

	Feedback getFeedbackById(Long id);

	Feedback saveFeedback(Feedback feedback);

	void deleteFeedback(Long id);
}
