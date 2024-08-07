package com.restaurantmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurantmanagementsystem.entity.Customer;
import com.restaurantmanagementsystem.exception.CustomerNotFoundException;
import com.restaurantmanagementsystem.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired // Injecting repository in service
	private CustomerRepository employeeRepository;

	public CustomerServiceImpl(CustomerRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Customer> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Customer findById(int custId) throws CustomerNotFoundException {
		Optional<Customer> result = employeeRepository.findById(custId);
		Customer customer;
		if (result.isPresent()) {
			customer = result.get();
		} else {
			throw new CustomerNotFoundException("Customer id not found : " + custId);
		}
		return customer;
	}

	@Override
	public void deleteById(int custId) throws CustomerNotFoundException {
		if (employeeRepository.existsById(custId)) {
			employeeRepository.deleteById(custId);
		} else {
			throw new CustomerNotFoundException("Customer with ID : " + custId + " not found");
		}
	}

	@Override
	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		return employeeRepository.save(customer);
	}
}
