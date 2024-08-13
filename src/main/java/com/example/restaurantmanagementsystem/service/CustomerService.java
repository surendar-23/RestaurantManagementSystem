package com.example.restaurantmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.restaurantmanagementsystem.entity.Customer;
import com.example.restaurantmanagementsystem.exception.ResourceNotFoundException;
import com.example.restaurantmanagementsystem.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Customer getCustomerById(Long id) {
		return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", id));
	}

	public Customer createCustomer(Customer customer) {
		customer.setEmail(customer.getEmail());
		customer.setName(customer.getName());
		customer.setOrders(customer.getOrders());
		customer.setPhone(customer.getPhone());
		return customerRepository.save(customer);
	}

	public Customer updateCustomer(Long id, Customer customer) {
		Customer existingCustomer = getCustomerById(id);
		existingCustomer.setEmail(customer.getEmail());
		existingCustomer.setName(customer.getName());
		existingCustomer.setOrders(customer.getOrders());
		existingCustomer.setPhone(customer.getPhone());
		return customerRepository.save(customer);
	}

	public ResponseEntity<Void> deleteCustomer(Long id) {
		customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", id));
		customerRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
