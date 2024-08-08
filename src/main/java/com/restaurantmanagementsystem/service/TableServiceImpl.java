package com.restaurantmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurantmanagementsystem.entity.Table;
import com.restaurantmanagementsystem.exception.TableNotFoundException;
import com.restaurantmanagementsystem.repository.TableRepository;

@Service
public class TableServiceImpl implements TableService {

	@Autowired
	private TableRepository tableRepository;

	@Override
	public List<Table> getAllTables() {
		return tableRepository.findAll();
	}

	@Override
	public Table getTableById(Long id) {
		return tableRepository.findById(id)
				.orElseThrow(() -> new TableNotFoundException("Table not found with id: " + id));
	}

	@Override
	public Table saveTable(Table table) {
		return tableRepository.save(table);
	}

	@Override
	public void deleteTable(Long id) {
		tableRepository.deleteById(id);
	}
}
