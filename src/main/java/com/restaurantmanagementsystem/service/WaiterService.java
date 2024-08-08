package com.restaurantmanagementsystem.service;

import java.util.List;

import com.restaurantmanagementsystem.entity.Order;
import com.restaurantmanagementsystem.entity.Waiter;

public interface WaiterService {
	Waiter findById(Long id);

	List<Waiter> findAll();

	Waiter save(Waiter waiter);

	void deleteById(Long id);

	void notifyOrderReady(Order order); // Add this method
}
