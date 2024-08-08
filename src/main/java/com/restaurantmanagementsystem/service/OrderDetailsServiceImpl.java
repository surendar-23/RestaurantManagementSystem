package com.restaurantmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurantmanagementsystem.entity.OrderDetails;
import com.restaurantmanagementsystem.exception.OrderDetailsNotFoundException;
import com.restaurantmanagementsystem.repository.OrderDetailsRepository;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	@Override
	public List<OrderDetails> getAllOrderDetails() {
		return orderDetailsRepository.findAll();
	}

	@Override
	public OrderDetails getOrderDetailsById(Long id) {
		return orderDetailsRepository.findById(id)
				.orElseThrow(() -> new OrderDetailsNotFoundException("Order details not found with id: " + id));
	}

	@Override
	public OrderDetails saveOrderDetails(OrderDetails orderDetails) {
		return orderDetailsRepository.save(orderDetails);
	}

	@Override
	public void deleteOrderDetails(Long id) {
		orderDetailsRepository.deleteById(id);
	}
}
