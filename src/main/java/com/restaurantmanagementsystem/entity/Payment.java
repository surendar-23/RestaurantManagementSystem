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
@jakarta.persistence.Table(name = "payments")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "bill_id")
	private Bill bill;

	private BigDecimal amountPaid;

	private Date paymentDate;

	private String paymentMethod;

	private boolean isPaid;

	public Payment() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public BigDecimal getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public Payment(Long id, Bill bill, BigDecimal amountPaid, Date paymentDate, String paymentMethod, boolean isPaid) {
		super();
		this.id = id;
		this.bill = bill;
		this.amountPaid = amountPaid;
		this.paymentDate = paymentDate;
		this.paymentMethod = paymentMethod;
		this.isPaid = isPaid;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", bill=" + bill + ", amountPaid=" + amountPaid + ", paymentDate=" + paymentDate
				+ ", paymentMethod=" + paymentMethod + ", isPaid=" + isPaid + "]";
	}

}
