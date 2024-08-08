package com.restaurantmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurantmanagementsystem.entity.Restaurant;
import com.restaurantmanagementsystem.exception.RestaurantNotFoundException;
import com.restaurantmanagementsystem.service.RestaurantService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	// Constructor injection (optional, if you prefer)
	public RestaurantController(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

	// Find All Restaurants
	@GetMapping("/restaurants")
	public ResponseEntity<List<Restaurant>> findAll() {
		List<Restaurant> restaurants = restaurantService.getAllRestaurants();
		return new ResponseEntity<>(restaurants, HttpStatus.OK);
	}

	// Find By Id
	@GetMapping("/restaurants/{restaurantId}")
	public ResponseEntity<Restaurant> getById(@PathVariable Long restaurantId) {
		Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
		return new ResponseEntity<>(restaurant, HttpStatus.OK);
	}

	// Adding Restaurant
	@PostMapping("/restaurants")
	public ResponseEntity<Restaurant> addRestaurant(@Valid @RequestBody Restaurant restaurant) {
		restaurant.setId(0L); // Ensure new restaurant ID is generated
		Restaurant createdRestaurant = restaurantService.createRestaurant(restaurant);
		return new ResponseEntity<>(createdRestaurant, HttpStatus.OK);
	}

	// Updating Restaurant
	@PutMapping("/restaurants")
	public ResponseEntity<Restaurant> updateRestaurant(@Valid @RequestBody Restaurant restaurant)
			throws RestaurantNotFoundException {
		if (restaurant.getId() == null || restaurant.getId() <= 0) {
			throw new RestaurantNotFoundException("Restaurant ID must be provided for update");
		}
		Restaurant updatedRestaurant = restaurantService.updateRestaurant(restaurant);
		return new ResponseEntity<>(updatedRestaurant, HttpStatus.OK);
	}

	// Delete a Restaurant
	@DeleteMapping("/restaurants/{restaurantId}")
	public String deleteRestaurant(@PathVariable Long restaurantId) {
		try {
			restaurantService.deleteRestaurant(restaurantId);
			return "Deleted Restaurant ID : " + restaurantId;
		} catch (RestaurantNotFoundException e) {
			return "Restaurant with ID : " + restaurantId + " not found";
		}
	}
}
