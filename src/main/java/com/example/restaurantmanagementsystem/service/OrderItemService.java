package com.example.restaurantmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.restaurantmanagementsystem.entity.OrderItem;
import com.example.restaurantmanagementsystem.exception.ResourceNotFoundException;
import com.example.restaurantmanagementsystem.repository.OrderItemRepository;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;

	public List<OrderItem> getAllOrderItems() {
		return orderItemRepository.findAll();
	}

	public OrderItem getOrderItemById(Long id) {
		return orderItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrderItem", "Id", id));
	}

	public OrderItem createOrderItem(OrderItem orderItem) {
		orderItem.setOrder(orderItem.getOrder());
		orderItem.setPrice(orderItem.getPrice());
		orderItem.setQuantity(orderItem.getQuantity());
		return orderItemRepository.save(orderItem);
	}

	public OrderItem updateOrderItem(Long id, OrderItem orderItem) {
		OrderItem existingOrderItem = getOrderItemById(id);
		existingOrderItem.setOrder(orderItem.getOrder());
		existingOrderItem.setPrice(orderItem.getPrice());
		existingOrderItem.setQuantity(orderItem.getQuantity());
		return orderItemRepository.save(existingOrderItem);
	}

	public ResponseEntity<Void> deleteOrderItem(Long id) {
		orderItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrderItem", "Id", id));
		orderItemRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
