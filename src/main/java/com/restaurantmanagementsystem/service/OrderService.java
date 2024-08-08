package com.restaurantmanagementsystem.service;

import java.util.List;

import com.restaurantmanagementsystem.entity.Order;

public interface OrderService {
	List<Order> getAllOrders();

	Order getOrderById(Long id);

	Order saveOrder(Order order);

	void deleteOrder(Long id);
}
