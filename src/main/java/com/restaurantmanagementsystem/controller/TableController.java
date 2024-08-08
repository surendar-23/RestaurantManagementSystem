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

import com.restaurantmanagementsystem.entity.Table;
import com.restaurantmanagementsystem.service.TableService;

@RestController
@RequestMapping("/api/tables")
public class TableController {

	@Autowired
	private TableService tableService;

	@GetMapping
	public ResponseEntity<List<Table>> findAll() {
		List<Table> tables = tableService.getAllTables();
		return new ResponseEntity<>(tables, HttpStatus.OK);
	}

	@GetMapping("/{tableId}")
	public ResponseEntity<Table> getById(@PathVariable Long tableId) {
		Table table = tableService.getTableById(tableId);
		return new ResponseEntity<>(table, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Table> addTable(@RequestBody Table table) {
		Table createdTable = tableService.saveTable(table);
		return new ResponseEntity<>(createdTable, HttpStatus.CREATED);
	}

	@PutMapping("/{tableId}")
	public ResponseEntity<Table> updateTable(@PathVariable Long tableId, @RequestBody Table table) {
		table.setId(tableId);
		Table updatedTable = tableService.saveTable(table);
		return new ResponseEntity<>(updatedTable, HttpStatus.OK);
	}

	@DeleteMapping("/{tableId}")
	public ResponseEntity<Void> deleteTable(@PathVariable Long tableId) {
		tableService.deleteTable(tableId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
