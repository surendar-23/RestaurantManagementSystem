package com.example.restaurantmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.restaurantmanagementsystem.entity.Owner;
import com.example.restaurantmanagementsystem.exception.ResourceNotFoundException;
import com.example.restaurantmanagementsystem.repository.OwnerRepository;

@Service
public class OwnerService {

	@Autowired
	private OwnerRepository ownerRepository;

	public List<Owner> getAllOwner() {
		return ownerRepository.findAll();
	}

	public Owner getOwnerById(Long id) {
		return ownerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Owner", "Id", id));
	}

	public Owner createOwner(Owner owner) {
		System.out.println("Owner added Successfully " + owner);
		owner.setAccountings(owner.getAccountings());
		owner.setAddress(owner.getAddress());
		owner.setContact(owner.getPhone(), owner.getEmail());
		owner.setEmail(owner.getEmail());
		owner.setName(owner.getName());
		owner.setPhone(owner.getPhone());
		owner.setRestaurants(owner.getRestaurants());
		return ownerRepository.save(owner);

	}

	public Owner updateOwner(Long id, Owner owner) {
		Owner existingOwner = getOwnerById(id);
		existingOwner.setAccountings(owner.getAccountings());
		existingOwner.setAddress(owner.getAddress());
		existingOwner.setContact(owner.getPhone(), owner.getEmail());
		existingOwner.setEmail(owner.getEmail());
		existingOwner.setName(owner.getName());
		existingOwner.setPhone(owner.getPhone());
		existingOwner.setRestaurants(owner.getRestaurants());
		return ownerRepository.save(existingOwner);
	}

	public ResponseEntity<Void> deleteOwner(Long id) {
		ownerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Owner", "Id", id));
		ownerRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
