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

import com.example.restaurantmanagementsystem.entity.OrderDetails;
import com.example.restaurantmanagementsystem.service.OrderDetailsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/orderDetails")
public class OrderDetailsController {

	@Autowired
	private OrderDetailsService orderDetailsService;

	@GetMapping("")
	public List<OrderDetails> getAllOrderDetails() {
		return orderDetailsService.getAllOrderDetails();
	}

	@GetMapping("/{id}")
	public OrderDetails getOrderDetailsById(@PathVariable Long id) {
		return orderDetailsService.getOrderDetailsById(id);
	}

	@PostMapping("")
	public OrderDetails createOrderDetails(@RequestBody OrderDetails orderDetails) {
		return orderDetailsService.createOrderDetails(orderDetails);
	}

	@PutMapping("/{id}")
	public OrderDetails updateOrderDetails(@PathVariable Long id, @RequestBody OrderDetails orderDetails) {
		return orderDetailsService.updateOrderDetails(id, orderDetails);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteOrderDetails(@PathVariable Long id) {
		return orderDetailsService.deleteOrderDetails(id);
	}
}
