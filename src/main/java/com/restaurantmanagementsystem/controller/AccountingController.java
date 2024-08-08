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

import com.restaurantmanagementsystem.entity.Accounting;
import com.restaurantmanagementsystem.service.AccountingService;

@RestController
@RequestMapping("/api/accounting")
public class AccountingController {

	@Autowired
	private AccountingService accountingService;

	@GetMapping
	public ResponseEntity<List<Accounting>> findAll() {
		List<Accounting> accountings = accountingService.getAllAccountings();
		return new ResponseEntity<>(accountings, HttpStatus.OK);
	}

	@GetMapping("/{accountingId}")
	public ResponseEntity<Accounting> getById(@PathVariable Long accountingId) {
		Accounting accounting = accountingService.getAccountingById(accountingId);
		return new ResponseEntity<>(accounting, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Accounting> addAccounting(@RequestBody Accounting accounting) {
		Accounting createdAccounting = accountingService.saveAccounting(accounting);
		return new ResponseEntity<>(createdAccounting, HttpStatus.CREATED);
	}

	@PutMapping("/{accountingId}")
	public ResponseEntity<Accounting> updateAccounting(@PathVariable Long accountingId,
			@RequestBody Accounting accounting) {
		accounting.setId(accountingId);
		Accounting updatedAccounting = accountingService.saveAccounting(accounting);
		return new ResponseEntity<>(updatedAccounting, HttpStatus.OK);
	}

	@DeleteMapping("/{accountingId}")
	public ResponseEntity<Void> deleteAccounting(@PathVariable Long accountingId) {
		accountingService.deleteAccounting(accountingId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
