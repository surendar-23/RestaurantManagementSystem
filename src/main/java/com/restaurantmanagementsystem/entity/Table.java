package com.restaurantmanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@jakarta.persistence.Table(name = "tables")
public class Table {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private boolean isAc;

	private boolean isOccupied;

	public Table() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isAc() {
		return isAc;
	}

	public void setAc(boolean isAc) {
		this.isAc = isAc;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public Table(Long id, boolean isAc, boolean isOccupied) {
		super();
		this.id = id;
		this.isAc = isAc;
		this.isOccupied = isOccupied;
	}

	@Override
	public String toString() {
		return "Table [id=" + id + ", isAc=" + isAc + ", isOccupied=" + isOccupied + "]";
	}

}
