package com.restaurantmanagementsystem.service;

import java.util.List;

import com.restaurantmanagementsystem.entity.InventoryItem;

public interface InventoryItemService {
	InventoryItem getInventoryItemById(Long id);

	List<InventoryItem> getAllInventoryItems();

	InventoryItem saveInventoryItem(InventoryItem inventoryItem);

	void deleteInventoryItem(Long id);

	boolean checkAvailability(String itemName, int quantity);
}
