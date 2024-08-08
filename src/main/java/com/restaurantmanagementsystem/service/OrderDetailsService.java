package com.restaurantmanagementsystem.service;

import java.util.List;

import com.restaurantmanagementsystem.entity.OrderDetails;

public interface OrderDetailsService {
	List<OrderDetails> getAllOrderDetails();

	OrderDetails getOrderDetailsById(Long id);

	OrderDetails saveOrderDetails(OrderDetails orderDetails);

	void deleteOrderDetails(Long id);
}
