package com.restaurantmanagementsystem.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@jakarta.persistence.Table(name = "bills")
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "order_id")
	private Order order;

	private BigDecimal totalAmount;

	private Date billDate;

	private boolean isPaid;

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

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public Bill() {
		super();
	}

	public Bill(Long id, Order order, BigDecimal totalAmount, Date billDate, boolean isPaid) {
		super();
		this.id = id;
		this.order = order;
		this.totalAmount = totalAmount;
		this.billDate = billDate;
		this.isPaid = isPaid;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", order=" + order + ", totalAmount=" + totalAmount + ", billDate=" + billDate
				+ ", isPaid=" + isPaid + "]";
	}

}
