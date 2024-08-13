package com.example.restaurantmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.restaurantmanagementsystem.entity.Waiter;
import com.example.restaurantmanagementsystem.exception.ResourceNotFoundException;
import com.example.restaurantmanagementsystem.repository.WaiterRepository;

@Service
public class WaiterService {

	@Autowired
	private WaiterRepository waiterRepository;

	public List<Waiter> getAllWaiter() {
		return waiterRepository.findAll();
	}

	public Waiter getWaiterById(Long id) {
		return waiterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Waiter", "Id", id));
	}

	public Waiter createWaiter(Waiter waiter) {
		System.out.println("Waiter added Successfully " + waiter);
		waiter.setName(waiter.getName());
		waiter.setExperience(waiter.getExperience());
		waiter.setRestaurant(waiter.getRestaurant());
		return waiterRepository.save(waiter);
	}

	public Waiter updateWaiter(Long id, Waiter waiter) {
		Waiter existingWaiter = getWaiterById(id);
		existingWaiter.setName(waiter.getName());
		existingWaiter.setExperience(waiter.getExperience());
		existingWaiter.setRestaurant(waiter.getRestaurant());
		return waiterRepository.save(existingWaiter);
	}

	public ResponseEntity<Void> deleteWaiter(Long id) {
		waiterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Waiter", "Id", id));
		waiterRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
