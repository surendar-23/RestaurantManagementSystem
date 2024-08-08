package com.restaurantmanagementsystem.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@jakarta.persistence.Table(name = "order_details")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "menu_item_id")
	private MenuItem menuItem;

	private int quantity;

	@ManyToOne
	@JoinColumn(name = "chef_id")
	private Chef chef;

	private BigDecimal price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public OrderDetails() {
		super();
	}

	public OrderDetails(Long id, Order order, MenuItem menuItem, int quantity, Chef chef, BigDecimal price) {
		super();
		this.id = id;
		this.order = order;
		this.menuItem = menuItem;
		this.quantity = quantity;
		this.chef = chef;
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", order=" + order + ", menuItem=" + menuItem + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}

}
