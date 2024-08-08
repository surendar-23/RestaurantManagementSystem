package com.restaurantmanagementsystem.service;

import java.util.List;

import com.restaurantmanagementsystem.entity.Chef;
import com.restaurantmanagementsystem.entity.Order;

public interface ChefService {

	Chef getChefById(Long id);

	List<Chef> getAllChefs();

	Chef saveChef(Chef chef);

	void deleteById(Long id);

	void prepareOrder(Order order);

	void notifyWaiter(Order order);
}
