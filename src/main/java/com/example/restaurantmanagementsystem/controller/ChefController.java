package com.example.restaurantmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurantmanagementsystem.entity.Chef;
import com.example.restaurantmanagementsystem.service.ChefService;

@RestController
@RequestMapping("/api/chef")
public class ChefController {

	@Autowired
	private ChefService chefService;

	@GetMapping("")
	public List<Chef> getAllChef() {
		return chefService.getAllChef();
	}

	@GetMapping("/{id}")
	public Chef getChefById(@PathVariable Long id) {
		return chefService.getChefById(id);
	}

	@PostMapping("")
	public Chef createChef(@RequestBody Chef chef) {
		return chefService.createChef(chef);
	}

	@PutMapping("/{id}")
	public Chef updateChef(@PathVariable Long id, @RequestBody Chef chef) {
		return chefService.updateChef(id, chef);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteChef(@PathVariable Long id) {
		return chefService.deleteChef(id);
	}
}
