package com.restaurantmanagementsystem.service;

import java.util.List;

import com.restaurantmanagementsystem.entity.Restaurant;
import com.restaurantmanagementsystem.exception.RestaurantNotFoundException;

import jakarta.validation.Valid;

public interface RestaurantService {
	Restaurant createRestaurant(@Valid Restaurant restaurant);

	List<Restaurant> getAllRestaurants();

	Restaurant getRestaurantById(Long id) throws RestaurantNotFoundException;

	void deleteRestaurant(Long id);

	Restaurant updateRestaurant(Restaurant restaurant);
}
