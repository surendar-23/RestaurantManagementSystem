package com.restaurantmanagementsystem.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Customer_Details")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;

	@NotBlank(message = "Customer name is required")
	private String customerName;

	@OneToOne(cascade = CascadeType.ALL) // Add cascade type
	@JoinColumn(name = "address_id")
	private Address customerAddress;

	@Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
	private String phoneNumber;

	public Customer() {
	}

	public Customer(int customerId, String customerName, Address customerAddress, String phoneNumber) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.phoneNumber = phoneNumber;
	}

	// Getters and setters

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Address getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", phoneNumber=" + phoneNumber + "]";
	}
}
