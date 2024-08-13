package com.example.restaurantmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.restaurantmanagementsystem.entity.Chef;
import com.example.restaurantmanagementsystem.exception.ResourceNotFoundException;
import com.example.restaurantmanagementsystem.repository.ChefRepository;

@Service
public class ChefService {

	@Autowired
	private ChefRepository chefRepository;

	public List<Chef> getAllChef() {
		return chefRepository.findAll();
	}

	public Chef getChefById(Long id) {
		return chefRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Chef", "Id", id));
	}

	public Chef createChef(Chef chef) {
		System.out.println("Chef added Successfully " + chef);
		chef.setExperience(chef.getExperience());
		chef.setName(chef.getName());
		chef.setRestaurant(chef.getRestaurant());
		return chefRepository.save(chef);
	}

	public Chef updateChef(Long id, Chef chef) {
		Chef existingChef = getChefById(id);
		existingChef.setName(chef.getName());
		existingChef.setExperience(chef.getExperience());
		existingChef.setRestaurant(chef.getRestaurant());
		return chefRepository.save(existingChef);
	}

	public ResponseEntity<Void> deleteChef(Long id) {
		chefRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Chef", "Id", id));
		chefRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
