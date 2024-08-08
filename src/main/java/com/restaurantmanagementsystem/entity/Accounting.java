package com.restaurantmanagementsystem.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@jakarta.persistence.Table(name = "accounting")
public class Accounting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date date;

	private int numberOfOrdersTaken;

	private BigDecimal billAmountGenerated;

	private BigDecimal expenses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getNumberOfOrdersTaken() {
		return numberOfOrdersTaken;
	}

	public void setNumberOfOrdersTaken(int numberOfOrdersTaken) {
		this.numberOfOrdersTaken = numberOfOrdersTaken;
	}

	public BigDecimal getBillAmountGenerated() {
		return billAmountGenerated;
	}

	public void setBillAmountGenerated(BigDecimal billAmountGenerated) {
		this.billAmountGenerated = billAmountGenerated;
	}

	public BigDecimal getExpenses() {
		return expenses;
	}

	public void setExpenses(BigDecimal expenses) {
		this.expenses = expenses;
	}

	public Accounting() {
		super();
	}

	public Accounting(Long id, Date date, int numberOfOrdersTaken, BigDecimal billAmountGenerated,
			BigDecimal expenses) {
		super();
		this.id = id;
		this.date = date;
		this.numberOfOrdersTaken = numberOfOrdersTaken;
		this.billAmountGenerated = billAmountGenerated;
		this.expenses = expenses;
	}

	@Override
	public String toString() {
		return "Accounting [id=" + id + ", date=" + date + ", numberOfOrdersTaken=" + numberOfOrdersTaken
				+ ", billAmountGenerated=" + billAmountGenerated + ", expenses=" + expenses + "]";
	}

}
