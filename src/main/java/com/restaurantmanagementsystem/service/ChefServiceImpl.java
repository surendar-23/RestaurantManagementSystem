package com.restaurantmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.restaurantmanagementsystem.entity.Chef;
import com.restaurantmanagementsystem.entity.InventoryItem;
import com.restaurantmanagementsystem.entity.MenuItem;
import com.restaurantmanagementsystem.entity.Order;
import com.restaurantmanagementsystem.entity.OrderItem;
import com.restaurantmanagementsystem.exception.ChefNotFoundException;
import com.restaurantmanagementsystem.exception.InventoryItemNotFoundException;
import com.restaurantmanagementsystem.repository.ChefRepository;
import com.restaurantmanagementsystem.repository.InventoryItemRepository;

@Service
public class ChefServiceImpl implements ChefService {

	private final ChefRepository chefRepository;
	private final InventoryItemRepository inventoryItemRepository;
	private final WaiterService waiterService;

	public ChefServiceImpl(ChefRepository chefRepository, InventoryItemRepository inventoryItemRepository,
			WaiterService waiterService) {
		this.chefRepository = chefRepository;
		this.inventoryItemRepository = inventoryItemRepository;
		this.waiterService = waiterService;
	}

	@Override
	public void deleteById(Long id) {
		chefRepository.deleteById(id);
	}

	@Override
	public void prepareOrder(Order order) {
		for (OrderItem orderItem : order.getOrderItems()) {
			MenuItem menuItem = orderItem.getMenuItem();

			InventoryItem inventoryItem = inventoryItemRepository.findByName(menuItem.getName()).orElseThrow(
					() -> new InventoryItemNotFoundException("Inventory item not found: " + menuItem.getName()));

			if (inventoryItem.getQuantity() < orderItem.getQuantity()) {
				throw new InventoryItemNotFoundException("Not enough stock for item: " + menuItem.getName());
			}

			inventoryItem.setQuantity(inventoryItem.getQuantity() - orderItem.getQuantity());
			inventoryItemRepository.save(inventoryItem);

			System.out.println("Preparing " + orderItem.getQuantity() + " x " + menuItem.getName());
		}

		notifyWaiter(order);
	}

	@Override
	public void notifyWaiter(Order order) {
		waiterService.notifyOrderReady(order);
		System.out.println("Order ID " + order.getId() + " is ready for delivery.");
	}

	@Override
	public Chef getChefById(Long id) {
		Optional<Chef> result = chefRepository.findById(id);

		return result.orElseThrow(() -> new ChefNotFoundException("Did not find chef id - " + id));
	}

	@Override
	public List<Chef> getAllChefs() {
		return chefRepository.findAll();
	}

	@Override
	public Chef saveChef(Chef chef) {
		return chefRepository.save(chef);
	}
}
