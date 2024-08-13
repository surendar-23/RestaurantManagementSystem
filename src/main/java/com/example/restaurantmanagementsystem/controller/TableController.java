package com.example.restaurantmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurantmanagementsystem.entity.Table;
import com.example.restaurantmanagementsystem.service.TableService;

@RestController
@RequestMapping("/api/table")

public class TableController {

	@Autowired
	private TableService tableService;

	@GetMapping("")
	public List<Table> getAllTable() {
		return tableService.getAllTable();
	}

	@GetMapping("/{id}")
	public Table getTableById(@PathVariable Long id) {
		return tableService.getTableById(id);
	}

	@PostMapping("")
	public Table createTable(@RequestBody Table table) {
		return tableService.createTable(table);
	}

	@PutMapping("/{id}")
	public Table updateTable(@PathVariable Long id, @RequestBody Table table) {
		return tableService.updateTable(id, table);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTable(@PathVariable Long id) {
		return tableService.deleteTable(id);
	}
}
