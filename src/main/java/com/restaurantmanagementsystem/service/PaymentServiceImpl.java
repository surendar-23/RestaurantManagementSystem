package com.restaurantmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurantmanagementsystem.entity.Payment;
import com.restaurantmanagementsystem.exception.PaymentNotFoundException;
import com.restaurantmanagementsystem.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}

	@Override
	public Payment getPaymentById(Long id) {
		return paymentRepository.findById(id)
				.orElseThrow(() -> new PaymentNotFoundException("Payment not found with id: " + id));
	}

	@Override
	public Payment savePayment(Payment payment) {
		return paymentRepository.save(payment);
	}

	@Override
	public void deletePayment(Long id) {
		paymentRepository.deleteById(id);
	}
}
