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

import com.restaurantmanagementsystem.entity.MenuItem;
import com.restaurantmanagementsystem.service.MenuItemService;

@RestController
@RequestMapping("/api/menu-items")
public class MenuItemController {

	@Autowired
	private MenuItemService menuItemService;

	@GetMapping
	public ResponseEntity<List<MenuItem>> findAll() {
		List<MenuItem> menuItems = menuItemService.getAllMenuItems();
		return new ResponseEntity<>(menuItems, HttpStatus.OK);
	}

	@GetMapping("/{menuItemId}")
	public ResponseEntity<MenuItem> getById(@PathVariable Long menuItemId) {
		MenuItem menuItem = menuItemService.getMenuItemById(menuItemId);
		return new ResponseEntity<>(menuItem, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<MenuItem> addMenuItem(@RequestBody MenuItem menuItem) {
		MenuItem createdMenuItem = menuItemService.saveMenuItem(menuItem);
		return new ResponseEntity<>(createdMenuItem, HttpStatus.CREATED);
	}

	@PutMapping("/{menuItemId}")
	public ResponseEntity<MenuItem> updateMenuItem(@PathVariable Long menuItemId, @RequestBody MenuItem menuItem) {
		menuItem.setId(menuItemId);
		MenuItem updatedMenuItem = menuItemService.saveMenuItem(menuItem);
		return new ResponseEntity<>(updatedMenuItem, HttpStatus.OK);
	}

	@DeleteMapping("/{menuItemId}")
	public ResponseEntity<Void> deleteMenuItem(@PathVariable Long menuItemId) {
		menuItemService.deleteMenuItem(menuItemId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
