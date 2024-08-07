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

import com.restaurantmanagementsystem.entity.Customer;
import com.restaurantmanagementsystem.exception.CustomerNotFoundException;
import com.restaurantmanagementsystem.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// Constructor injection (optional, if you prefer)
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	// Find All Customers
	@GetMapping("customers")
	public ResponseEntity<List<Customer>> findAll() {
		List<Customer> customers = customerService.findAll();
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	// Find By Id
	@GetMapping("customers/{customerId}")
	public ResponseEntity<Customer> getById(@PathVariable int customerId) {
		Customer customer = customerService.findById(customerId);
		if (customer != null) {
			return new ResponseEntity<>(customer, HttpStatus.OK);
		} else {
			throw new CustomerNotFoundException("Customer not found with id: " + customerId);
		}
	}

	// Updating Customer
	@PutMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer)
			throws CustomerNotFoundException {
		if (customer.getCustomerId() <= 0) {
			throw new CustomerNotFoundException("Customer ID must be provided for update");
		}
		Customer updatedCustomer = customerService.save(customer);
		return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
	}

	// Adding Customer
	@PostMapping("/customers")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer) {
		customer.setCustomerId(0); // Ensure new customer ID is generated
		Customer createdCustomer = customerService.save(customer);
		return new ResponseEntity<>(createdCustomer, HttpStatus.OK);
	}

	// Delete a Customer
	@DeleteMapping("customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		try {
			customerService.deleteById(customerId);
			return "Deleted Customer ID : " + customerId;
		} catch (CustomerNotFoundException e) {
			return "Customer with ID : " + customerId + " not found";
		}
	}
}
