package com.restaurantmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurantmanagementsystem.entity.Accounting;
import com.restaurantmanagementsystem.exception.AccountingNotFoundException;
import com.restaurantmanagementsystem.repository.AccountingRepository;

@Service
public class AccountingServiceImpl implements AccountingService {

	@Autowired
	private AccountingRepository accountingRepository;

	@Override
	public List<Accounting> getAllAccountings() {
		return accountingRepository.findAll();
	}

	@Override
	public Accounting getAccountingById(Long id) {
		return accountingRepository.findById(id)
				.orElseThrow(() -> new AccountingNotFoundException("Accounting record not found with id: " + id));
	}

	@Override
	public Accounting saveAccounting(Accounting accounting) {
		return accountingRepository.save(accounting);
	}

	@Override
	public void deleteAccounting(Long id) {
		accountingRepository.deleteById(id);
	}
}
