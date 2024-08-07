package com.restaurantmanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Restaurant name is required")
	private String name;

	@NotBlank(message = "Restaurant address is required")
	private String address;

	public Restaurant() {
	}

	public Restaurant(Long id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Restaurant{" + "id=" + id + ", name='" + name + '\'' + ", address='" + address + '\'' + '}';
	}
}
