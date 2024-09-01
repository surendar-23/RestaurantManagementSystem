package com.example.restaurantmanagementsystem.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Owner name is required")
	private String name;

	@NotBlank(message = "Phone number is required")
	private String phone;

	@NotBlank(message = "Email is required")
	@Email(message = "Email should be valid")
	private String email;

	@NotNull(message = "Address is required")
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private List<Restaurant> restaurants;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private List<Accounting> accountings;

	// Getters and Setters

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	public List<Accounting> getAccountings() {
		return accountings;
	}

	public void setAccountings(List<Accounting> accountings) {
		this.accountings = accountings;
	}

	// Method to get contact information
	public String getContact() {
		return "Phone: " + phone + ", Email: " + email;
	}

	public void setContact(String phone, String email) {
		this.phone = phone;
		this.email = email;
	}
}
