package com.restaurantmanagementsystem.service;

import java.util.List;

import com.restaurantmanagementsystem.entity.Customer;
import com.restaurantmanagementsystem.exception.CustomerNotFoundException;

public interface CustomerService {
	public List<Customer> findAll();

	public Customer findById(int custId) throws CustomerNotFoundException;

	public Customer save(Customer customer);

	public void deleteById(int custId) throws CustomerNotFoundException;
}
