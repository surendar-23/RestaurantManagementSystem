package com.example.restaurantmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.restaurantmanagementsystem.entity.Accounting;
import com.example.restaurantmanagementsystem.exception.ResourceNotFoundException;
import com.example.restaurantmanagementsystem.repository.AccountingRepository;

@Service
public class AccountingService {

	@Autowired
	private AccountingRepository accountingRepository;

	public List<Accounting> getAllAccounting() {
		return accountingRepository.findAll();
	}

	public Accounting getAccountingById(Long id) {
		return accountingRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Accounting", "Id", id));
	}

	public Accounting createAccounting(Accounting account) {
		System.out.println("Accounting added Successfully " + account);
		account.setAmount(account.getAmount());
		account.setBills(account.getBills());
		account.setDate(account.getDate());
		account.setOwner(account.getOwner());
		return accountingRepository.save(account);
	}

	public Accounting updateAccounting(Long id, Accounting account) {
		Accounting existingAccounting = getAccountingById(id);
		existingAccounting.setAmount(account.getAmount());
		existingAccounting.setDate(account.getDate());
		existingAccounting.setBills(account.getBills());
		existingAccounting.setOwner(account.getOwner());
		return accountingRepository.save(existingAccounting);
	}

	public ResponseEntity<Void> deleteAccounting(Long id) {
		accountingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Accounting", "Id", id));
		accountingRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
