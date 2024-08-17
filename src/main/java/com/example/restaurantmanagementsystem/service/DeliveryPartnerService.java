package com.example.restaurantmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.restaurantmanagementsystem.entity.DeliveryPartner;
import com.example.restaurantmanagementsystem.exception.ResourceNotFoundException;
import com.example.restaurantmanagementsystem.repository.DeliveryPartnerRepository;

@Service
public class DeliveryPartnerService {

	@Autowired
	private DeliveryPartnerRepository deliveryPartnerRepository;

	public List<DeliveryPartner> getAllDeliveryPartners() {
		return deliveryPartnerRepository.findAll();
	}

	public DeliveryPartner getDeliveryPartnerById(Long id) {
		return deliveryPartnerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("DeliveryPartner", "Id", id));
	}

	public DeliveryPartner createDeliveryPartner(DeliveryPartner deliveryPartner) {
		deliveryPartner.setContactNumber(deliveryPartner.getContactNumber());
		deliveryPartner.setDeliveries(deliveryPartner.getDeliveries());
		deliveryPartner.setName(deliveryPartner.getName());
		deliveryPartner.setRestaurant(deliveryPartner.getRestaurant());
		return deliveryPartnerRepository.save(deliveryPartner);
	}

	public DeliveryPartner updateDeliveryPartner(Long id, DeliveryPartner deliveryPartner) {
		DeliveryPartner existingPartner = getDeliveryPartnerById(id);
		existingPartner.setContactNumber(deliveryPartner.getContactNumber());
		existingPartner.setDeliveries(deliveryPartner.getDeliveries());
		existingPartner.setName(deliveryPartner.getName());
		existingPartner.setRestaurant(deliveryPartner.getRestaurant());
		return deliveryPartnerRepository.save(existingPartner);
	}

	public ResponseEntity<Void> deleteDeliveryPartner(Long id) {
		deliveryPartnerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("DeliveryPartner", "Id", id));
		deliveryPartnerRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
