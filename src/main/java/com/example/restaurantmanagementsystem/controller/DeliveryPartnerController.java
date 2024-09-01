package com.example.restaurantmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurantmanagementsystem.entity.DeliveryPartner;
import com.example.restaurantmanagementsystem.service.DeliveryPartnerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/delivery-partners")
public class DeliveryPartnerController {

	@Autowired
	private DeliveryPartnerService deliveryPartnerService;

	@GetMapping
	public List<DeliveryPartner> getAllDeliveryPartners() {
		return deliveryPartnerService.getAllDeliveryPartners();
	}

	@GetMapping("/{id}")
	public ResponseEntity<DeliveryPartner> getDeliveryPartnerById(@PathVariable Long id) {
		DeliveryPartner partner = deliveryPartnerService.getDeliveryPartnerById(id);
		return ResponseEntity.ok(partner);
	}

	@PostMapping
	public ResponseEntity<DeliveryPartner> createDeliveryPartner(@RequestBody DeliveryPartner deliveryPartner) {
		DeliveryPartner createdPartner = deliveryPartnerService.createDeliveryPartner(deliveryPartner);
		return ResponseEntity.ok(createdPartner);
	}

	@PutMapping("/{id}")
	public ResponseEntity<DeliveryPartner> updateDeliveryPartner(@PathVariable Long id,
			@RequestBody DeliveryPartner deliveryPartner) {
		DeliveryPartner updatedPartner = deliveryPartnerService.updateDeliveryPartner(id, deliveryPartner);
		return ResponseEntity.ok(updatedPartner);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDeliveryPartner(@PathVariable Long id) {
		return deliveryPartnerService.deleteDeliveryPartner(id);
	}
}
