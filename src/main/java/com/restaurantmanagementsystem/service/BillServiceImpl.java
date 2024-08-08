package com.restaurantmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurantmanagementsystem.entity.Bill;
import com.restaurantmanagementsystem.exception.BillNotFoundException;
import com.restaurantmanagementsystem.repository.BillRepository;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepository billRepository;

	@Override
	public List<Bill> getAllBills() {
		return billRepository.findAll();
	}

	@Override
	public Bill getBillById(Long id) {
		return billRepository.findById(id)
				.orElseThrow(() -> new BillNotFoundException("Bill not found with id: " + id));
	}

	@Override
	public Bill saveBill(Bill bill) {
		return billRepository.save(bill);
	}

	@Override
	public void deleteBill(Long id) {
		billRepository.deleteById(id);
	}
}
