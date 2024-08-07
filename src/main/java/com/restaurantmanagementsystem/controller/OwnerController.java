package com.restaurantmanagementsystem.controller;

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

import com.restaurantmanagementsystem.entity.Owner;
import com.restaurantmanagementsystem.exception.OwnerNotFoundException;
import com.restaurantmanagementsystem.service.OwnerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class OwnerController {

	@Autowired
	private OwnerService ownerService;

	// Constructor injection (optional, if you prefer)
	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	// Find By Id
	@GetMapping("owners/{ownerId}")
	public ResponseEntity<Owner> getById(@PathVariable Long ownerId) {
		Owner owner = ownerService.getOwnerById(ownerId);
		if (owner != null) {
			return new ResponseEntity<>(owner, HttpStatus.OK);
		} else {
			throw new OwnerNotFoundException("Owner not found with id: " + ownerId);
		}
	}

	// Adding Owner
	@PostMapping("/owners")
	public ResponseEntity<Owner> addOwner(@Valid @RequestBody Owner owner) {
		owner.setId(0L); // Ensure new owner ID is generated
		Owner createdOwner = ownerService.createOwner(owner);
		return new ResponseEntity<>(createdOwner, HttpStatus.OK);
	}

	// Updating Owner
	@PutMapping("/owners")
	public ResponseEntity<Owner> updateOwner(@Valid @RequestBody Owner owner) throws OwnerNotFoundException {
		if (owner.getId() == null || owner.getId() <= 0) {
			throw new OwnerNotFoundException("Owner ID must be provided for update");
		}
		Owner updatedOwner = ownerService.updateOwner(owner);
		return new ResponseEntity<>(updatedOwner, HttpStatus.OK);
	}

	// Delete an Owner
	@DeleteMapping("owners/{ownerId}")
	public String deleteOwner(@PathVariable Long ownerId) {
		try {
			ownerService.deleteOwner(ownerId);
			return "Deleted Owner ID : " + ownerId;
		} catch (OwnerNotFoundException e) {
			return "Owner with ID : " + ownerId + " not found";
		}
	}
}
