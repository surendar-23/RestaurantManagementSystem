package com.example.restaurantmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.restaurantmanagementsystem.entity.Payment;
import com.example.restaurantmanagementsystem.exception.ResourceNotFoundException;
import com.example.restaurantmanagementsystem.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Payment", "Id", id));
    }

    public Payment createPayment(Payment payment) {
        System.out.println("Payment added Successfully " + payment);
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(Long id, Payment payment) {
        Payment existingPayment = getPaymentById(id);
        existingPayment.setAmount(payment.getAmount());
        existingPayment.setOrder(payment.getOrder());
        existingPayment.setPaymentDate(payment.getPaymentDate());
        return paymentRepository.save(existingPayment);
    }

    public ResponseEntity<Void> deletePayment(Long id) {
        paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Payment", "Id", id));
        paymentRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
