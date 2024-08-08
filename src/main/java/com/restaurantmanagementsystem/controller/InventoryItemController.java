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

import com.restaurantmanagementsystem.entity.InventoryItem;
import com.restaurantmanagementsystem.service.InventoryItemService;

@RestController
@RequestMapping("/api/inventory-items")
public class InventoryItemController {

	@Autowired
	private InventoryItemService inventoryItemService;

	@GetMapping
	public ResponseEntity<List<InventoryItem>> findAll() {
		List<InventoryItem> inventoryItems = inventoryItemService.getAllInventoryItems();
		return new ResponseEntity<>(inventoryItems, HttpStatus.OK);
	}

	@GetMapping("/{inventoryItemId}")
	public ResponseEntity<InventoryItem> getById(@PathVariable Long inventoryItemId) {
		InventoryItem inventoryItem = inventoryItemService.getInventoryItemById(inventoryItemId);
		return new ResponseEntity<>(inventoryItem, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<InventoryItem> addInventoryItem(@RequestBody InventoryItem inventoryItem) {
		InventoryItem createdInventoryItem = inventoryItemService.saveInventoryItem(inventoryItem);
		return new ResponseEntity<>(createdInventoryItem, HttpStatus.CREATED);
	}

	@PutMapping("/{inventoryItemId}")
	public ResponseEntity<InventoryItem> updateInventoryItem(@PathVariable Long inventoryItemId,
			@RequestBody InventoryItem inventoryItem) {
		inventoryItem.setId(inventoryItemId);
		InventoryItem updatedInventoryItem = inventoryItemService.saveInventoryItem(inventoryItem);
		return new ResponseEntity<>(updatedInventoryItem, HttpStatus.OK);
	}

	@DeleteMapping("/{inventoryItemId}")
	public ResponseEntity<Void> deleteInventoryItem(@PathVariable Long inventoryItemId) {
		inventoryItemService.deleteInventoryItem(inventoryItemId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
