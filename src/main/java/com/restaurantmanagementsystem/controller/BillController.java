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

import com.restaurantmanagementsystem.entity.Bill;
import com.restaurantmanagementsystem.service.BillService;

@RestController
@RequestMapping("/api/bills")
public class BillController {

	@Autowired
	private BillService billService;

	@GetMapping
	public ResponseEntity<List<Bill>> findAll() {
		List<Bill> bills = billService.getAllBills();
		return new ResponseEntity<>(bills, HttpStatus.OK);
	}

	@GetMapping("/{billId}")
	public ResponseEntity<Bill> getById(@PathVariable Long billId) {
		Bill bill = billService.getBillById(billId);
		return new ResponseEntity<>(bill, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Bill> addBill(@RequestBody Bill bill) {
		Bill createdBill = billService.saveBill(bill);
		return new ResponseEntity<>(createdBill, HttpStatus.CREATED);
	}

	@PutMapping("/{billId}")
	public ResponseEntity<Bill> updateBill(@PathVariable Long billId, @RequestBody Bill bill) {
		bill.setId(billId);
		Bill updatedBill = billService.saveBill(bill);
		return new ResponseEntity<>(updatedBill, HttpStatus.OK);
	}

	@DeleteMapping("/{billId}")
	public ResponseEntity<Void> deleteBill(@PathVariable Long billId) {
		billService.deleteBill(billId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
