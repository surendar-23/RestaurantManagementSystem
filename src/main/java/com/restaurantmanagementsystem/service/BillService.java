package com.restaurantmanagementsystem.service;

import java.util.List;

import com.restaurantmanagementsystem.entity.Bill;

public interface BillService {
	List<Bill> getAllBills();

	Bill getBillById(Long id);

	Bill saveBill(Bill bill);

	void deleteBill(Long id);
}
