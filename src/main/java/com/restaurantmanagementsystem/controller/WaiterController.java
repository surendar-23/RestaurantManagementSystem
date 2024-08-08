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

import com.restaurantmanagementsystem.entity.Waiter;
import com.restaurantmanagementsystem.service.WaiterService;

@RestController
@RequestMapping("/api/waiters")
public class WaiterController {

	@Autowired
	private WaiterService waiterService;

	@GetMapping
	public ResponseEntity<List<Waiter>> findAll() {
		List<Waiter> waiters = waiterService.findAll();
		return new ResponseEntity<>(waiters, HttpStatus.OK);
	}

	@GetMapping("/{waiterId}")
	public ResponseEntity<Waiter> getById(@PathVariable Long waiterId) {
		Waiter waiter = waiterService.findById(waiterId);
		return new ResponseEntity<>(waiter, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Waiter> addWaiter(@RequestBody Waiter waiter) {
		Waiter createdWaiter = waiterService.save(waiter);
		return new ResponseEntity<>(createdWaiter, HttpStatus.CREATED);
	}

	@PutMapping("/{waiterId}")
	public ResponseEntity<Waiter> updateWaiter(@PathVariable Long waiterId, @RequestBody Waiter waiter) {
		waiter.setId(waiterId);
		Waiter updatedWaiter = waiterService.save(waiter);
		return new ResponseEntity<>(updatedWaiter, HttpStatus.OK);
	}

	@DeleteMapping("/{waiterId}")
	public ResponseEntity<Void> deleteWaiter(@PathVariable Long waiterId) {
		waiterService.deleteById(waiterId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
