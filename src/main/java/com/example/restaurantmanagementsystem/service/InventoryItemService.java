package com.example.restaurantmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.restaurantmanagementsystem.entity.InventoryItem;
import com.example.restaurantmanagementsystem.exception.ResourceNotFoundException;
import com.example.restaurantmanagementsystem.repository.InventoryItemRepository;

@Service
public class InventoryItemService {

	@Autowired
	private InventoryItemRepository inventoryItemRepository;

	public List<InventoryItem> getAllInventoryItem() {
		return inventoryItemRepository.findAll();
	}

	public InventoryItem getInventoryItemById(Long id) {
		return inventoryItemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("InventoryItem", "Id", id));
	}

	public InventoryItem createInventoryItem(InventoryItem inventoryItem) {
		inventoryItem.setName(inventoryItem.getName());
		inventoryItem.setQuantity(inventoryItem.getQuantity());
		inventoryItem.setSupplier(inventoryItem.getSupplier());
		return inventoryItemRepository.save(inventoryItem);
	}

	public InventoryItem updateInventoryItem(Long id, InventoryItem inventoryItem) {
		InventoryItem existingInventoryItem = getInventoryItemById(id);
		existingInventoryItem.setName(inventoryItem.getName());
		existingInventoryItem.setQuantity(inventoryItem.getQuantity());
		existingInventoryItem.setSupplier(inventoryItem.getSupplier());
		return inventoryItemRepository.save(existingInventoryItem);
	}

	public ResponseEntity<Void> deleteInventoryItem(Long id) {
		inventoryItemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("InventoryItem", "Id", id));
		inventoryItemRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
