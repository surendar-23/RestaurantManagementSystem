package com.example.restaurantmanagementsystem.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "accounting")
public class Accounting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Date is required")
    private Date date;

    @NotNull(message = "Amount is required")
    private double amount;

    @ManyToOne
    @JoinColumn(name = "owner_id") // Changed to a unique name
    @JsonIgnore
    private User owner;

    @OneToMany(mappedBy = "accounting", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Bill> bills;

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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public Accounting() {
        super();
    }

    public Accounting(Long id, @NotNull(message = "Date is required") Date date,
                      @NotNull(message = "Amount is required") double amount, User owner, List<Bill> bills) {
        super();
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.owner = owner;
        this.bills = bills;
    }

    @Override
    public String toString() {
        return "Accounting [id=" + id + ", date=" + date + ", amount=" + amount + ", owner=" + owner + ", bills="
                + bills + "]";
    }
}
