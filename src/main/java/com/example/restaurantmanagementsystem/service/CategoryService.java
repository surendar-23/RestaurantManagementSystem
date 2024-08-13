package com.example.restaurantmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.restaurantmanagementsystem.entity.Category;
import com.example.restaurantmanagementsystem.exception.ResourceNotFoundException;
import com.example.restaurantmanagementsystem.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	public Category getCategoryById(Long id) {
		return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", id));
	}

	public Category createCategory(Category category) {
		category.setName(category.getName());
		category.setMenuItems(category.getMenuItems());
		category.setDescription(category.getDescription());
		return categoryRepository.save(category);
	}

	public Category updateCategory(Long id, Category category) {
		Category existingCategory = getCategoryById(id);
		existingCategory.setName(category.getName());
		existingCategory.setMenuItems(category.getMenuItems());
		existingCategory.setDescription(category.getDescription());
		return categoryRepository.save(existingCategory);
	}

	public ResponseEntity<Void> deleteCategory(Long id) {
		categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", id));
		categoryRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
