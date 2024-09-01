package com.example.restaurantmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurantmanagementsystem.entity.Feedback;
import com.example.restaurantmanagementsystem.service.FeedbackService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;

	@GetMapping("")
	public List<Feedback> getAllFeedback() {
		return feedbackService.getAllFeedback();
	}

	@GetMapping("/{id}")
	public Feedback getFeedbackById(@PathVariable Long id) {
		return feedbackService.getFeedbackById(id);
	}

	@PostMapping("")
	public Feedback createFeedback(@RequestBody Feedback feedback) {
		return feedbackService.createFeedback(feedback);
	}

	@PutMapping("/{id}")
	public Feedback updateFeedback(@PathVariable Long id, @RequestBody Feedback feedback) {
		return feedbackService.updateFeedback(id, feedback);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteFeedback(@PathVariable Long id) {
		return feedbackService.deleteFeedback(id);
	}
}
