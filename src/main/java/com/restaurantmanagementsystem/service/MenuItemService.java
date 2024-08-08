package com.restaurantmanagementsystem.service;

import java.util.List;

import com.restaurantmanagementsystem.entity.MenuItem;

public interface MenuItemService {
	MenuItem getMenuItemById(Long id);

	List<MenuItem> getAllMenuItems();

	MenuItem saveMenuItem(MenuItem menuItem);

	void deleteMenuItem(Long id);

	List<MenuItem> findByType(String type); // e.g., AC or Non-AC
}
