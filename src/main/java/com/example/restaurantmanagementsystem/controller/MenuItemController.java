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

import com.example.restaurantmanagementsystem.entity.MenuItem;
import com.example.restaurantmanagementsystem.service.MenuItemService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/menuItem")
public class MenuItemController {

	@Autowired
	private MenuItemService menuItemService;

	@GetMapping("")
	public List<MenuItem> getAllMenuItem() {
		return menuItemService.getAllMenuItem();
	}

	@GetMapping("/{id}")
	public MenuItem getMenuItemById(@PathVariable Long id) {
		return menuItemService.getMenuItemById(id);
	}

	@PostMapping("")
	public MenuItem createMenuItem(@RequestBody MenuItem menuItem) {
		return menuItemService.createMenuItem(menuItem);
	}

	@PutMapping("/{id}")
	public MenuItem updateMenuItem(@PathVariable Long id, @RequestBody MenuItem menuItem) {
		return menuItemService.updateMenuItem(id, menuItem);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMenuItem(@PathVariable Long id) {
		return menuItemService.deleteMenuItem(id);
	}
}
