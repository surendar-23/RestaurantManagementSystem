package com.restaurantmanagementsystem.service;

import java.util.List;

import com.restaurantmanagementsystem.entity.Accounting;

public interface AccountingService {
	List<Accounting> getAllAccountings();

	Accounting getAccountingById(Long id);

	Accounting saveAccounting(Accounting accounting);

	void deleteAccounting(Long id);
}
