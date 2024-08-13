package com.example.restaurantmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.restaurantmanagementsystem.entity.Supplier;
import com.example.restaurantmanagementsystem.exception.ResourceNotFoundException;
import com.example.restaurantmanagementsystem.repository.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	public List<Supplier> getAllSuppliers() {
		return supplierRepository.findAll();
	}

	public Supplier getSupplierById(Long id) {
		return supplierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Supplier", "Id", id));
	}

	public Supplier createSupplier(Supplier supplier) {
		System.out.println("Supplier added Successfully " + supplier);
		supplier.setName(supplier.getName());
		supplier.setContactInformation(supplier.getContactInformation());
		supplier.setInventoryItems(supplier.getInventoryItems());
		return supplierRepository.save(supplier);
	}

	public Supplier updateSupplier(Long id, Supplier supplier) {
		Supplier existingSupplier = getSupplierById(id);
		existingSupplier.setName(supplier.getName());
		existingSupplier.setContactInformation(supplier.getContactInformation());
		existingSupplier.setInventoryItems(supplier.getInventoryItems());
		return supplierRepository.save(existingSupplier);
	}

	public ResponseEntity<Void> deleteSupplier(Long id) {
		supplierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Supplier", "Id", id));
		supplierRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
