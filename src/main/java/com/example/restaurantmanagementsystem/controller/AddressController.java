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

import com.example.restaurantmanagementsystem.entity.Address;
import com.example.restaurantmanagementsystem.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping("")
	public List<Address> getAllAddress() {
		return addressService.getAllAddress();
	}

	@GetMapping("/{id}")
	public Address getAddressById(@PathVariable Long id) {
		return addressService.getAddressById(id);
	}

	@PostMapping("")
	public Address createAddress(@RequestBody Address address) {
		return addressService.createAddress(address);
	}

	@PutMapping("/{id}")
	public Address updateAddress(@PathVariable Long id, @RequestBody Address address) {
		return addressService.updateAddress(id, address);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAddress(@PathVariable Long id) {
		return addressService.deleteAddress(id);
	}
}
