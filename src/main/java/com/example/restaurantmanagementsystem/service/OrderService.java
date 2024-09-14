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
	        return orderRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Order", "Id", id));
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

	 public Order updateOrder(Order updatedOrder, Long id) {
	        // Fetch the existing order
	        Order existingOrder = getOrderById(id);
	        
	        // Update the fields
	        existingOrder.setCustomer(updatedOrder.getCustomer());
	        existingOrder.setOrderDate(updatedOrder.getOrderDate());
	        existingOrder.setOrderDetails(updatedOrder.getOrderDetails());
	        existingOrder.setOrderItems(updatedOrder.getOrderItems());
	        existingOrder.setRestaurant(updatedOrder.getRestaurant());
	        existingOrder.setTable(updatedOrder.getTable());
	        existingOrder.setTotal(updatedOrder.getTotal());
	        existingOrder.setWaiter(updatedOrder.getWaiter());
	        
	        // Save and return the updated order
	        return orderRepository.save(existingOrder);
	    }

	public ResponseEntity<Void> deleteOrder(Long id) {
		orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order", "Id", id));
		orderRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
