package com.example.restaurantmanagementsystem.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Restaurant name is required")
	private String name;

	@NotNull(message = "Address is required")
	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@NotNull(message = "Owner is required")
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;

	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
	private List<Table> tables;

	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
	private List<Waiter> waiters;

	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
	private List<MenuItem> menuItems;

	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
	private List<InventoryItem> inventoryItems;

	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
	private List<DeliveryPartner> deliveryPartners;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public List<Table> getTables() {
		return tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}

	public List<Waiter> getWaiters() {
		return waiters;
	}

	public void setWaiters(List<Waiter> waiters) {
		this.waiters = waiters;
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	public List<InventoryItem> getInventoryItems() {
		return inventoryItems;
	}

	public void setInventoryItems(List<InventoryItem> inventoryItems) {
		this.inventoryItems = inventoryItems;
	}

	public List<DeliveryPartner> getDeliveryPartners() {
		return deliveryPartners;
	}

	public void setDeliveryPartners(List<DeliveryPartner> deliveryPartners) {
		this.deliveryPartners = deliveryPartners;
	}

	// Getters and Setters

}
