package com.example.restaurantmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurantmanagementsystem.entity.Bill;
import com.example.restaurantmanagementsystem.service.BillService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/bill")
public class BillController {

	@Autowired
	private BillService billService;

	@GetMapping("")
	public List<Bill> getAllBill() {
		return billService.getAllBill();
	}

	@GetMapping("/{id}")
	public Bill getBillById(@PathVariable Long id) {
		return billService.getBillById(id);
	}

	@PostMapping("")
	public Bill createBill(@RequestBody Bill bill) {
		return billService.createBill(bill);
	}

	@PutMapping("/{id}")
	public Bill updateBill(@PathVariable Long id, @RequestBody Bill bill) {
		return billService.updateBill(id, bill);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBill(@PathVariable Long id) {
		return billService.deleteBill(id);
	}
}
