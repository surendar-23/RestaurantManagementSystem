package com.example.restaurantmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.restaurantmanagementsystem.entity.Table;
import com.example.restaurantmanagementsystem.exception.ResourceNotFoundException;
import com.example.restaurantmanagementsystem.repository.TableRepository;

@Service
public class TableService {

	@Autowired
	private TableRepository tableRepository;

	public List<Table> getAllTable() {
		return tableRepository.findAll();
	}

	public Table getTableById(Long id) {
		return tableRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Table", "Id", id));
	}

	public Table createTable(Table table) {
		System.out.println("Table added Successfully " + table);
		table.setCapacity(table.getCapacity());
		table.setNumber(table.getNumber());
		table.setRestaurant(table.getRestaurant());
		table.setSeats(table.getSeats());
		return tableRepository.save(table);
	}

	public Table updateTable(Long id, Table table) {
		Table existingTable = getTableById(id);
		existingTable.setNumber(table.getNumber());
		existingTable.setCapacity(table.getCapacity());
		existingTable.setRestaurant(table.getRestaurant());
		existingTable.setSeats(table.getSeats());
		return tableRepository.save(existingTable);
	}

	public ResponseEntity<Void> deleteTable(Long id) {
		tableRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Table", "Id", id));
		tableRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
