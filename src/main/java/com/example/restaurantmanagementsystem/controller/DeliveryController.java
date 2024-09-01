package com.example.restaurantmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurantmanagementsystem.entity.Delivery;
import com.example.restaurantmanagementsystem.service.DeliveryService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {

	@Autowired
	private DeliveryService deliveryService;

	@GetMapping
	public List<Delivery> getAllDeliveries() {
		return deliveryService.getAllDeliveries();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Delivery> getDeliveryById(@PathVariable Long id) {
		Delivery delivery = deliveryService.getDeliveryById(id);
		return ResponseEntity.ok(delivery);
	}

	@PostMapping
	public ResponseEntity<Delivery> createDelivery(@RequestBody Delivery delivery) {
		Delivery createdDelivery = deliveryService.createDelivery(delivery);
		return ResponseEntity.ok(createdDelivery);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Delivery> updateDelivery(@PathVariable Long id, @RequestBody Delivery delivery) {
		Delivery updatedDelivery = deliveryService.updateDelivery(id, delivery);
		return ResponseEntity.ok(updatedDelivery);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDelivery(@PathVariable Long id) {
		return deliveryService.deleteDelivery(id);
	}
}
