package com.example.restaurantmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.restaurantmanagementsystem.entity.Order;
import com.example.restaurantmanagementsystem.exception.ResourceNotFoundException;
import com.example.restaurantmanagementsystem.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public Order getOrderById(Long id) {
		return orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order", "Id", id));
	}

	public Order createOrder(Order order) {
		System.out.println("Order added Successfully " + order);
		order.setCustomer(order.getCustomer());
		order.setOrderDate(order.getOrderDate());
		order.setOrderDetails(order.getOrderDetails());
		order.setOrderItems(order.getOrderItems());
		order.setRestaurant(order.getRestaurant());
		order.setTable(order.getTable());
		order.setTotal(order.getTotal());
		order.setWaiter(order.getWaiter());
		return orderRepository.save(order);
	}

	public Order updateOrder(Long id, Order order) {
		Order existingOrder = getOrderById(id);
		existingOrder.setCustomer(order.getCustomer());
		existingOrder.setOrderDate(order.getOrderDate());
		existingOrder.setOrderDetails(order.getOrderDetails());
		existingOrder.setOrderItems(order.getOrderItems());
		existingOrder.setRestaurant(order.getRestaurant());
		existingOrder.setTable(order.getTable());
		existingOrder.setTotal(order.getTotal());
		existingOrder.setWaiter(order.getWaiter());
		return orderRepository.save(existingOrder);
	}

	public ResponseEntity<Void> deleteOrder(Long id) {
		orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order", "Id", id));
		orderRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
