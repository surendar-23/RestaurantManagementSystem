package com.example.restaurantmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.restaurantmanagementsystem.entity.Feedback;
import com.example.restaurantmanagementsystem.exception.ResourceNotFoundException;
import com.example.restaurantmanagementsystem.repository.FeedbackRepository;

@Service
public class FeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepository;

	public List<Feedback> getAllFeedback() {
		return feedbackRepository.findAll();
	}

	public Feedback getFeedbackById(Long id) {
		return feedbackRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Feedback", "Id", id));
	}

	public Feedback createFeedback(Feedback feedback) {
		feedback.setComment(feedback.getComment());
		feedback.setOrder(feedback.getOrder());
		feedback.setRating(feedback.getRating());
		return feedbackRepository.save(feedback);
	}

	public Feedback updateFeedback(Long id, Feedback feedback) {
		Feedback existingFeedback = getFeedbackById(id);
		existingFeedback.setComment(feedback.getComment());
		existingFeedback.setOrder(feedback.getOrder());
		existingFeedback.setRating(feedback.getRating());
		return feedbackRepository.save(existingFeedback);
	}

	public ResponseEntity<Void> deleteFeedback(Long id) {
		feedbackRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Feedback", "Id", id));
		feedbackRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
