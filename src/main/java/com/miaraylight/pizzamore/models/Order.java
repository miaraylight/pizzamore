package com.miaraylight.pizzamore.models;

import java.util.List;

public class Order {
    public int orderNumber;
    public List<OrderItem> orderItems ;
    public double totalPrice;

    public Order(int orderNumber, List<OrderItem> orderItems, double totalPrice) {
        this.orderNumber = orderNumber;
        this.orderItems = orderItems;
        this.totalPrice = totalPrice;
    }
}
