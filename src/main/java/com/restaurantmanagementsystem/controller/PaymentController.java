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

import com.restaurantmanagementsystem.entity.Payment;
import com.restaurantmanagementsystem.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@GetMapping
	public ResponseEntity<List<Payment>> findAll() {
		List<Payment> payments = paymentService.getAllPayments();
		return new ResponseEntity<>(payments, HttpStatus.OK);
	}

	@GetMapping("/{paymentId}")
	public ResponseEntity<Payment> getById(@PathVariable Long paymentId) {
		Payment payment = paymentService.getPaymentById(paymentId);
		return new ResponseEntity<>(payment, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {
		Payment createdPayment = paymentService.savePayment(payment);
		return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
	}

	@PutMapping("/{paymentId}")
	public ResponseEntity<Payment> updatePayment(@PathVariable Long paymentId, @RequestBody Payment payment) {
		payment.setId(paymentId);
		Payment updatedPayment = paymentService.savePayment(payment);
		return new ResponseEntity<>(updatedPayment, HttpStatus.OK);
	}

	@DeleteMapping("/{paymentId}")
	public ResponseEntity<Void> deletePayment(@PathVariable Long paymentId) {
		paymentService.deletePayment(paymentId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
