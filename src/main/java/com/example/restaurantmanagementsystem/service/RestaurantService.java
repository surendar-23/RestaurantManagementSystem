package com.example.restaurantmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.restaurantmanagementsystem.entity.Restaurant;
import com.example.restaurantmanagementsystem.exception.ResourceNotFoundException;
import com.example.restaurantmanagementsystem.repository.RestaurantRepository;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	public List<Restaurant> getAllRestaurants() {
		return restaurantRepository.findAll();
	}

	public Restaurant getRestaurantById(Long id) {
		return restaurantRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Restaurant", "Id", id));
	}

	public Restaurant createRestaurant(Restaurant restaurant) {
		System.out.println("Restaurant added Successfully " + restaurant);
		restaurant.setAddress(restaurant.getAddress());
		restaurant.setInventoryItems(restaurant.getInventoryItems());
		restaurant.setMenuItems(restaurant.getMenuItems());
		restaurant.setName(restaurant.getName());
		restaurant.setOwner(restaurant.getOwner());
		restaurant.setTables(restaurant.getTables());
		restaurant.setWaiters(restaurant.getWaiters());
		return restaurantRepository.save(restaurant);
	}

	public Restaurant updateRestaurant(Long id, Restaurant restaurant) {
		Restaurant existingRestaurant = getRestaurantById(id);
		existingRestaurant.setAddress(restaurant.getAddress());
		existingRestaurant.setInventoryItems(restaurant.getInventoryItems());
		existingRestaurant.setMenuItems(restaurant.getMenuItems());
		existingRestaurant.setName(restaurant.getName());
		existingRestaurant.setOwner(restaurant.getOwner());
		existingRestaurant.setTables(restaurant.getTables());
		existingRestaurant.setWaiters(restaurant.getWaiters());
		return restaurantRepository.save(restaurant);
	}

	public ResponseEntity<Void> deleteRestaurant(Long id) {
		restaurantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Restaurant", "Id", id));
		restaurantRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
