package com.example.restaurantmanagementsystem.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
@jakarta.persistence.Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Order date is required")
    private Date orderDate;

    @NotNull(message = "Total is required")
    private Double total;

    @ManyToOne
    @JoinColumn(name = "customer_id") // Changed to a unique name
    private User customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id") // Changed to a unique name
    @JsonIgnore
    private User restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "waiter_id") // Changed to a unique name
    @JsonIgnore
    private User waiter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_id")
    @JsonIgnore
    private Table table;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OrderItem> orderItems;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OrderDetails> orderDetails;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(User restaurant) {
        this.restaurant = restaurant;
    }

    public User getWaiter() {
        return waiter;
    }

    public void setWaiter(User waiter) {
        this.waiter = waiter;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Order() {
        super();
    }

    public Order(Long id, @NotNull(message = "Order date is required") Date orderDate,
                 @NotNull(message = "Total is required") Double total, User customer, User restaurant,
                 List<OrderItem> orderItems, Table table, User waiter, List<OrderDetails> orderDetails) {
        super();
        this.id = id;
        this.orderDate = orderDate;
        this.total = total;
        this.customer = customer;
        this.restaurant = restaurant;
        this.orderItems = orderItems;
        this.table = table;
        this.waiter = waiter;
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", orderDate=" + orderDate + ", total=" + total + ", customer=" + customer
                + ", restaurant=" + restaurant + ", orderItems=" + orderItems + ", table=" + table + ", waiter="
                + waiter + ", orderDetails=" + orderDetails + "]";
    }
}
