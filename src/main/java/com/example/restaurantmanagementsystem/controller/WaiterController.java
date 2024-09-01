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

import com.example.restaurantmanagementsystem.entity.Waiter;
import com.example.restaurantmanagementsystem.service.WaiterService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/waiter")
public class WaiterController {

	@Autowired
	private WaiterService waiterService;

	@GetMapping("")
	public List<Waiter> getAllWaiter() {
		return waiterService.getAllWaiter();
	}

	@GetMapping("/{id}")
	public Waiter getWaiterById(@PathVariable Long id) {
		return waiterService.getWaiterById(id);
	}

	@PostMapping("")
	public Waiter createWaiter(@RequestBody Waiter waiter) {
		return waiterService.createWaiter(waiter);
	}

	@PutMapping("/{id}")
	public Waiter updateWaiter(@PathVariable Long id, @RequestBody Waiter waiter) {
		return waiterService.updateWaiter(id, waiter);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteWaiter(@PathVariable Long id) {
		return waiterService.deleteWaiter(id);
	}
}
