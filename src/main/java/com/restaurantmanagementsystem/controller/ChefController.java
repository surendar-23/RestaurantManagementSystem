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

import com.restaurantmanagementsystem.entity.Chef;
import com.restaurantmanagementsystem.service.ChefService;

@RestController
@RequestMapping("/api/chefs")
public class ChefController {

	@Autowired
	private ChefService chefService;

	@GetMapping
	public ResponseEntity<List<Chef>> findAll() {
		List<Chef> chefs = chefService.getAllChefs();
		return new ResponseEntity<>(chefs, HttpStatus.OK);
	}

	@GetMapping("/{chefId}")
	public ResponseEntity<Chef> getById(@PathVariable Long chefId) {
		Chef chef = chefService.getChefById(chefId);
		return new ResponseEntity<>(chef, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Chef> addChef(@RequestBody Chef chef) {
		Chef createdChef = chefService.saveChef(chef);
		return new ResponseEntity<>(createdChef, HttpStatus.CREATED);
	}

	@PutMapping("/{chefId}")
	public ResponseEntity<Chef> updateChef(@PathVariable Long chefId, @RequestBody Chef chef) {
		chef.setId(chefId);
		Chef updatedChef = chefService.saveChef(chef);
		return new ResponseEntity<>(updatedChef, HttpStatus.OK);
	}

	@DeleteMapping("/{chefId}")
	public ResponseEntity<Void> deleteChef(@PathVariable Long chefId) {
		chefService.deleteById(chefId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
