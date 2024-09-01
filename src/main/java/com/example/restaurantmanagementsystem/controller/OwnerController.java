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

import com.example.restaurantmanagementsystem.entity.Owner;
import com.example.restaurantmanagementsystem.service.OwnerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/owner")
public class OwnerController {

	@Autowired
	private OwnerService ownerService;

	@GetMapping("")
	public List<Owner> getAllOwner() {
		return ownerService.getAllOwner();
	}

	@GetMapping("/{id}")
	public Owner getOwnerById(@PathVariable Long id) {
		return ownerService.getOwnerById(id);
	}

	@PostMapping("")
	public Owner createOwner(@RequestBody Owner owner) {
		return ownerService.createOwner(owner);
	}

	@PutMapping("/{id}")
	public Owner updateOwner(@PathVariable Long id, @RequestBody Owner owner) {
		return ownerService.updateOwner(id, owner);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteOwner(@PathVariable Long id) {
		return ownerService.deleteOwner(id);
	}
}
