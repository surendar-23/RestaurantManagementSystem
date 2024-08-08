package com.restaurantmanagementsystem.service;

import java.util.List;

import com.restaurantmanagementsystem.entity.Payment;

public interface PaymentService {
	List<Payment> getAllPayments();

	Payment getPaymentById(Long id);

	Payment savePayment(Payment payment);

	void deletePayment(Long id);
}