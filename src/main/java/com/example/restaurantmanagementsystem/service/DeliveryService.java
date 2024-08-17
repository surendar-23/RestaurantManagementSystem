package com.example.restaurantmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.restaurantmanagementsystem.entity.Delivery;
import com.example.restaurantmanagementsystem.exception.ResourceNotFoundException;
import com.example.restaurantmanagementsystem.repository.DeliveryRepository;

@Service
public class DeliveryService {

	@Autowired
	private DeliveryRepository deliveryRepository;

	public List<Delivery> getAllDeliveries() {
		return deliveryRepository.findAll();
	}

	public Delivery getDeliveryById(Long id) {
		return deliveryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Delivery", "Id", id));
	}

	public Delivery createDelivery(Delivery delivery) {
		delivery.setCity(delivery.getCity());
		delivery.setDeliveryPartner(delivery.getDeliveryPartner());
		delivery.setDeliveryTime(delivery.getDeliveryTime());
		delivery.setOrder(delivery.getOrder());
		delivery.setPostalCode(delivery.getPostalCode());
		delivery.setState(delivery.getState());
		delivery.setStatus(delivery.getStatus());
		delivery.setStreet(delivery.getStreet());
		return deliveryRepository.save(delivery);
	}

	public Delivery updateDelivery(Long id, Delivery delivery) {
		Delivery existingDelivery = getDeliveryById(id);
		existingDelivery.setDeliveryPartner(delivery.getDeliveryPartner());
		existingDelivery.setDeliveryTime(delivery.getDeliveryTime());
		existingDelivery.setOrder(delivery.getOrder());
		existingDelivery.setPostalCode(delivery.getPostalCode());
		existingDelivery.setState(delivery.getState());
		existingDelivery.setStatus(delivery.getStatus());
		existingDelivery.setStreet(delivery.getStreet());
		return deliveryRepository.save(existingDelivery);
	}

	public ResponseEntity<Void> deleteDelivery(Long id) {
		deliveryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Delivery", "Id", id));
		deliveryRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
