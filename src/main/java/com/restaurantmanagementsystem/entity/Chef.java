package com.restaurantmanagementsystem.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@jakarta.persistence.Table(name = "chefs")
public class Chef {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToMany(mappedBy = "chef", cascade = CascadeType.ALL)
	private List<OrderDetails> orderDetails;

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

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Chef() {
		super();
	}

	public Chef(Long id, String name, List<OrderDetails> orderDetails) {
		super();
		this.id = id;
		this.name = name;
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "Chef [id=" + id + ", name=" + name + ", orderDetails=" + orderDetails + "]";
	}

}
