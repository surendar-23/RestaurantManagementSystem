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

import com.example.restaurantmanagementsystem.entity.InventoryItem;
import com.example.restaurantmanagementsystem.service.InventoryItemService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/inventoryItem")
public class InventoryItemController {

	@Autowired
	private InventoryItemService inventoryItemService;

	@GetMapping("")
	public List<InventoryItem> getAllInventoryItem() {
		return inventoryItemService.getAllInventoryItem();
	}

	@GetMapping("/{id}")
	public InventoryItem getInventoryItemById(@PathVariable Long id) {
		return inventoryItemService.getInventoryItemById(id);
	}

	@PostMapping("")
	public InventoryItem createInventoryItem(@RequestBody InventoryItem inventoryItem) {
		return inventoryItemService.createInventoryItem(inventoryItem);
	}

	@PutMapping("/{id}")
	public InventoryItem updateInventoryItem(@PathVariable Long id, @RequestBody InventoryItem inventoryItem) {
		return inventoryItemService.updateInventoryItem(id, inventoryItem);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteInventoryItem(@PathVariable Long id) {
		return inventoryItemService.deleteInventoryItem(id);
	}
}