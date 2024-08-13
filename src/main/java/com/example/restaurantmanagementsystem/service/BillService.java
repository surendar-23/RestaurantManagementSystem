package com.example.restaurantmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.restaurantmanagementsystem.entity.Bill;
import com.example.restaurantmanagementsystem.exception.ResourceNotFoundException;
import com.example.restaurantmanagementsystem.repository.BillRepository;

@Service
public class BillService {

	@Autowired
	private BillRepository billRepository;

	public List<Bill> getAllBill() {
		return billRepository.findAll();
	}

	public Bill getBillById(Long id) {
		return billRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bill", "Id", id));
	}

	public Bill createBill(Bill bill) {
		System.out.println("Bill added Successfully " + bill);
		bill.setAccounting(bill.getAccounting());
		bill.setAmount(bill.getAmount());
		bill.setDate(bill.getDate());
		bill.setDescription(bill.getDescription());
		return billRepository.save(bill);

	}

	public Bill updateBill(Long id, Bill bill) {
		Bill existingBill = getBillById(id);
		existingBill.setAccounting(bill.getAccounting());
		existingBill.setAmount(bill.getAmount());
		existingBill.setDate(bill.getDate());
		existingBill.setDescription(bill.getDescription());
		return billRepository.save(existingBill);
	}

	public ResponseEntity<Void> deleteBill(Long id) {
		billRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bill", "Id", id));
		billRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
