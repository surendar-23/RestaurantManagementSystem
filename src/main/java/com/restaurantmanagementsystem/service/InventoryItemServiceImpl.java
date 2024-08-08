package com.restaurantmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.restaurantmanagementsystem.entity.InventoryItem;
import com.restaurantmanagementsystem.exception.InventoryItemNotFoundException;
import com.restaurantmanagementsystem.repository.InventoryItemRepository;

@Service
public class InventoryItemServiceImpl implements InventoryItemService {

	private InventoryItemRepository inventoryItemRepository;

	public InventoryItemServiceImpl(InventoryItemRepository inventoryItemRepository) {
		this.inventoryItemRepository = inventoryItemRepository;
	}

	@Override
	public boolean checkAvailability(String itemName, int quantity) {
		Optional<InventoryItem> result = inventoryItemRepository.findByName(itemName);

		if (result.isPresent()) {
			InventoryItem inventoryItem = result.get();
			return inventoryItem.getQuantity() >= quantity;
		}

		return false;
	}

	@Override
	public InventoryItem getInventoryItemById(Long id) {
		Optional<InventoryItem> result = inventoryItemRepository.findById(id);

		InventoryItem inventoryItem = null;

		if (result.isPresent()) {
			inventoryItem = result.get();
		} else {
			throw new InventoryItemNotFoundException("Did not find inventory item id - " + id);
		}

		return inventoryItem;
	}

	@Override
	public List<InventoryItem> getAllInventoryItems() {
		return inventoryItemRepository.findAll();
	}

	@Override
	public InventoryItem saveInventoryItem(InventoryItem inventoryItem) {
		return inventoryItemRepository.save(inventoryItem);
	}

	@Override
	public void deleteInventoryItem(Long id) {
		inventoryItemRepository.deleteById(id);

	}
}
