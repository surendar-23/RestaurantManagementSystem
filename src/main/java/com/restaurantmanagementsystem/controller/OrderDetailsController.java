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

import com.restaurantmanagementsystem.entity.OrderDetails;
import com.restaurantmanagementsystem.service.OrderDetailsService;

@RestController
@RequestMapping("/api/order-details")
public class OrderDetailsController {

	@Autowired
	private OrderDetailsService orderDetailsService;

	@GetMapping
	public ResponseEntity<List<OrderDetails>> findAll() {
		List<OrderDetails> orderDetailsList = orderDetailsService.getAllOrderDetails();
		return new ResponseEntity<>(orderDetailsList, HttpStatus.OK);
	}

	@GetMapping("/{orderDetailsId}")
	public ResponseEntity<OrderDetails> getById(@PathVariable Long orderDetailsId) {
		OrderDetails orderDetails = orderDetailsService.getOrderDetailsById(orderDetailsId);
		return new ResponseEntity<>(orderDetails, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<OrderDetails> addOrderDetails(@RequestBody OrderDetails orderDetails) {
		OrderDetails createdOrderDetails = orderDetailsService.saveOrderDetails(orderDetails);
		return new ResponseEntity<>(createdOrderDetails, HttpStatus.CREATED);
	}

	@PutMapping("/{orderDetailsId}")
	public ResponseEntity<OrderDetails> updateOrderDetails(@PathVariable Long orderDetailsId,
			@RequestBody OrderDetails orderDetails) {
		orderDetails.setId(orderDetailsId);
		OrderDetails updatedOrderDetails = orderDetailsService.saveOrderDetails(orderDetails);
		return new ResponseEntity<>(updatedOrderDetails, HttpStatus.OK);
	}

	@DeleteMapping("/{orderDetailsId}")
	public ResponseEntity<Void> deleteOrderDetails(@PathVariable Long orderDetailsId) {
		orderDetailsService.deleteOrderDetails(orderDetailsId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
