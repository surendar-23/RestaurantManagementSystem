package com.restaurantmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.restaurantmanagementsystem.entity.MenuItem;
import com.restaurantmanagementsystem.exception.MenuItemNotFoundException;
import com.restaurantmanagementsystem.repository.MenuItemRepository;

@Service
public class MenuItemServiceImpl implements MenuItemService {

	private MenuItemRepository menuItemRepository;

	public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
		this.menuItemRepository = menuItemRepository;
	}

	@Override
	public MenuItem getMenuItemById(Long id) {
		Optional<MenuItem> result = menuItemRepository.findById(id);

		MenuItem menuItem = null;

		if (result.isPresent()) {
			menuItem = result.get();
		} else {
			throw new MenuItemNotFoundException("Did not find menu item id - " + id);
		}

		return menuItem;
	}

	@Override
	public List<MenuItem> getAllMenuItems() {
		return menuItemRepository.findAll();
	}

	@Override
	public MenuItem saveMenuItem(MenuItem menuItem) {
		return menuItemRepository.save(menuItem);
	}

	@Override
	public void deleteMenuItem(Long id) {
		menuItemRepository.deleteById(id);
	}

	@Override
	public List<MenuItem> findByType(String type) {
		return menuItemRepository.findByType(type);
	}
}
