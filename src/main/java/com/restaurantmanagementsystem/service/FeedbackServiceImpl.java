package com.restaurantmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurantmanagementsystem.entity.Feedback;
import com.restaurantmanagementsystem.exception.FeedbackNotFoundException;
import com.restaurantmanagementsystem.repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepository;

	@Override
	public List<Feedback> getAllFeedbacks() {
		return feedbackRepository.findAll();
	}

	@Override
	public Feedback getFeedbackById(Long id) {
		return feedbackRepository.findById(id)
				.orElseThrow(() -> new FeedbackNotFoundException("Feedback not found with id: " + id));
	}

	@Override
	public Feedback saveFeedback(Feedback feedback) {
		return feedbackRepository.save(feedback);
	}

	@Override
	public void deleteFeedback(Long id) {
		feedbackRepository.deleteById(id);
	}
}
