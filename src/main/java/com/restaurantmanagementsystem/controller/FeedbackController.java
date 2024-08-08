package com.restaurantmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurantmanagementsystem.entity.Feedback;
import com.restaurantmanagementsystem.service.FeedbackService;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;

	@GetMapping
	public ResponseEntity<List<Feedback>> findAll() {
		List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
		return new ResponseEntity<>(feedbacks, HttpStatus.OK);
	}

	@GetMapping("/{feedbackId}")
	public ResponseEntity<Feedback> getById(@PathVariable Long feedbackId) {
		Feedback feedback = feedbackService.getFeedbackById(feedbackId);
		return new ResponseEntity<>(feedback, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback) {
		Feedback createdFeedback = feedbackService.saveFeedback(feedback);
		return new ResponseEntity<>(createdFeedback, HttpStatus.CREATED);
	}

	@PutMapping("/{feedbackId}")
	public ResponseEntity<Feedback> updateFeedback(@PathVariable Long feedbackId, @RequestBody Feedback feedback) {
		feedback.setId(feedbackId);
		Feedback updatedFeedback = feedbackService.saveFeedback(feedback);
		return new ResponseEntity<>(updatedFeedback, HttpStatus.OK);
	}

	@DeleteMapping("/{feedbackId}")
	public ResponseEntity<Void> deleteFeedback(@PathVariable Long feedbackId) {
		feedbackService.deleteFeedback(feedbackId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
