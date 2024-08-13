package com.example.restaurantmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.restaurantmanagementsystem.entity.Address;
import com.example.restaurantmanagementsystem.exception.ResourceNotFoundException;
import com.example.restaurantmanagementsystem.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	public List<Address> getAllAddress() {
		return addressRepository.findAll();
	}

	public Address getAddressById(Long id) {
		return addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Address", "Id", id));
	}

	public Address createAddress(Address address) {
		address.setCity(address.getCity());
		address.setState(address.getState());
		address.setStreet(address.getStreet());
		address.setZip(address.getZip());
		return addressRepository.save(address);
	}

	public Address updateAddress(Long id, Address address) {
		Address existingAddress = getAddressById(id);
		existingAddress.setCity(address.getCity());
		existingAddress.setState(address.getState());
		existingAddress.setStreet(address.getStreet());
		existingAddress.setZip(address.getZip());
		return addressRepository.save(existingAddress);
	}

	public ResponseEntity<Void> deleteAddress(Long id) {
		addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Address", "Id", id));
		addressRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
