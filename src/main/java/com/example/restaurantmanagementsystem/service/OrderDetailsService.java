package com.example.restaurantmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.restaurantmanagementsystem.entity.OrderDetails;
import com.example.restaurantmanagementsystem.exception.ResourceNotFoundException;
import com.example.restaurantmanagementsystem.repository.OrderDetailsRepository;

@Service
public class OrderDetailsService {

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	public List<OrderDetails> getAllOrderDetails() {
		return orderDetailsRepository.findAll();
	}

	public OrderDetails getOrderDetailsById(Long id) {
		return orderDetailsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("OrderDetails", "Id", id));
	}

	public OrderDetails createOrderDetails(OrderDetails orderDetails) {
		System.out.println("Order Details added Successfully " + orderDetails);
		orderDetails.setBill(orderDetails.getBill());
		orderDetails.setMenuItem(orderDetails.getMenuItem());
		orderDetails.setOrder(orderDetails.getOrder());
		orderDetails.setOrderDate(orderDetails.getOrderDate());
		orderDetails.setTotalAmount(orderDetails.getTotalAmount());
		return orderDetailsRepository.save(orderDetails);
	}

	public OrderDetails updateOrderDetails(Long id, OrderDetails orderDetails) {
		OrderDetails existingOrderDetails = getOrderDetailsById(id);
		existingOrderDetails.setBill(orderDetails.getBill());
		existingOrderDetails.setMenuItem(orderDetails.getMenuItem());
		existingOrderDetails.setOrder(orderDetails.getOrder());
		existingOrderDetails.setOrderDate(orderDetails.getOrderDate());
		existingOrderDetails.setTotalAmount(orderDetails.getTotalAmount());
		return orderDetailsRepository.save(existingOrderDetails);
	}

	public ResponseEntity<Void> deleteOrderDetails(Long id) {
		orderDetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrderDetails", "Id", id));
		orderDetailsRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
