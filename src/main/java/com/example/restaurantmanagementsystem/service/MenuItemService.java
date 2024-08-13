package com.example.restaurantmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.restaurantmanagementsystem.entity.MenuItem;
import com.example.restaurantmanagementsystem.exception.ResourceNotFoundException;
import com.example.restaurantmanagementsystem.repository.MenuItemRepository;

@Service
public class MenuItemService {

	@Autowired
	private MenuItemRepository menuItemRepository;

	public MenuItem createMenuItem(MenuItem menuItem) {
		System.out.println("Menu Item added Successfully " + menuItem);
		menuItem.setName(menuItem.getName());
		menuItem.setPrice(menuItem.getPrice());
		menuItem.setCategory(menuItem.getCategory());
		menuItem.setRestaurant(menuItem.getRestaurant());
		return menuItemRepository.save(menuItem);
	}

	public List<MenuItem> getAllMenuItem() {
		return menuItemRepository.findAll();
	}

	public MenuItem getMenuItemById(Long id) {
		return menuItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("MenuItem", "Id", id));
	}

	public MenuItem updateMenuItem(Long id, MenuItem menuItem) {
		MenuItem existingMenuItem = getMenuItemById(id);
		existingMenuItem.setName(menuItem.getName());
		existingMenuItem.setPrice(menuItem.getPrice());
		existingMenuItem.setCategory(menuItem.getCategory());
		existingMenuItem.setRestaurant(menuItem.getRestaurant());
		return menuItemRepository.save(existingMenuItem);
	}

	public ResponseEntity<Void> deleteMenuItem(Long id) {
		menuItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("MenuItem", "Id", id));
		menuItemRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
