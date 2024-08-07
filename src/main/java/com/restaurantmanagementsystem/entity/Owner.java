package com.restaurantmanagementsystem.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Owner name is required")
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurant_id", referencedColumnName = "id")
	private Restaurant restaurant;

	public Owner() {
	}

	public Owner(Long id, String name, Restaurant restaurant) {
		this.id = id;
		this.name = name;
		this.restaurant = restaurant;
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

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "Owner{" + "id=" + id + ", name='" + name + '\'' + ", restaurant=" + restaurant + '}';
	}
}
