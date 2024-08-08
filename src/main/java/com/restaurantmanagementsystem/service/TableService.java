package com.restaurantmanagementsystem.service;

import java.util.List;

import com.restaurantmanagementsystem.entity.Table;

public interface TableService {
	List<Table> getAllTables();

	Table getTableById(Long id);

	Table saveTable(Table table);

	void deleteTable(Long id);
}
