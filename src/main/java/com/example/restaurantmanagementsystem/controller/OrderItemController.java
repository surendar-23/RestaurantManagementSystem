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

import com.example.restaurantmanagementsystem.entity.OrderItem;
import com.example.restaurantmanagementsystem.service.OrderItemService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/orderItems")
public class OrderItemController {

	@Autowired
	private OrderItemService orderItemService;

	@GetMapping("")
	public List<OrderItem> getAllOrderItems() {
		return orderItemService.getAllOrderItems();
	}

	@GetMapping("/{id}")
	public OrderItem getOrderItemById(@PathVariable Long id) {
		return orderItemService.getOrderItemById(id);
	}

	@PostMapping("")
	public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
		return orderItemService.createOrderItem(orderItem);
	}

	@PutMapping("/{id}")
	public OrderItem updateOrderItem(@PathVariable Long id, @RequestBody OrderItem orderItem) {
		return orderItemService.updateOrderItem(id, orderItem);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteOrderItem(@PathVariable Long id) {
		orderItemService.deleteOrderItem(id);
		return ResponseEntity.noContent().build();
	}
}
