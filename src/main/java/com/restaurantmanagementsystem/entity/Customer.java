package com.restaurantmanagementsystem.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@jakarta.persistence.Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "customer")
	private List<Order> orders = new ArrayList<>();

	// Constructors, getters, setters
	public Customer() {
	}

	public Customer(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Customer(Long id, List<Order> orders) {
		super();
		this.id = id;
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", orders=" + orders + "]";
	}

}
