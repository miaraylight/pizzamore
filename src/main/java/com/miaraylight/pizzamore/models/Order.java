package com.miaraylight.pizzamore.models;

import java.util.ArrayList;
import java.util.List;

import java.util.UUID;

public class Order {
    private final String orderId;
    private List<OrderItem> orderItems;
    private double discount = 0.0;  // flat discount or percent later

    public Order() {
        this.orderId = UUID.randomUUID().toString().substring(0, 8); // short ID
        this.orderItems = new ArrayList<>();
    }

    public String getOrderId() {
        return orderId;
    }

    public void applyDiscount(double amount) {
        this.discount = amount;
    }

    public double getSubtotal() {
        return orderItems.stream().mapToDouble(OrderItem::getPrice).sum();
    }

    public double getTax() {

        double TAX_RATE = 0.02;// 2% tax in my dreams
        return (getSubtotal() - discount) * TAX_RATE;
    }

    public double getTotalPrice() {
        return getSubtotal() - discount + getTax();
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public OrderItem addToOrder(OrderItem item) {
        orderItems.add(item);
        return item;
    }
}

