package com.restaurantmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.restaurantmanagementsystem.entity.Order;
import com.restaurantmanagementsystem.entity.Waiter;
import com.restaurantmanagementsystem.exception.WaiterNotFoundException;
import com.restaurantmanagementsystem.repository.WaiterRepository;

@Service
public class WaiterServiceImpl implements WaiterService {

	private final WaiterRepository waiterRepository;

	public WaiterServiceImpl(WaiterRepository waiterRepository) {
		this.waiterRepository = waiterRepository;
	}

	@Override
	public Waiter findById(Long id) {
		Optional<Waiter> result = waiterRepository.findById(id);
		return result.orElseThrow(() -> new WaiterNotFoundException("Did not find waiter id - " + id));
	}

	@Override
	public List<Waiter> findAll() {
		return waiterRepository.findAll();
	}

	@Override
	public Waiter save(Waiter waiter) {
		return waiterRepository.save(waiter);
	}

	@Override
	public void deleteById(Long id) {
		waiterRepository.deleteById(id);
	}

	@Override
	public void notifyOrderReady(Order order) {
		Long waiterId = order.getWaiterId();

		if (waiterId == null) {
			throw new RuntimeException("No waiter assigned to this order.");
		}

		Waiter waiter = findById(waiterId);

		if (waiter == null) {
			throw new WaiterNotFoundException("Did not find waiter with id - " + waiterId);
		}

		System.out.println("Notifying waiter " + waiter.getName() + " that order " + order.getId() + " is ready.");

		// Example: Update waiter status (pseudo code)
		waiter.addPendingOrder(order);
		save(waiter);
	}
}
