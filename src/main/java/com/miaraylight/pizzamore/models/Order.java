package com.miaraylight.pizzamore.models;

import java.util.List;
import java.util.Random;

public class Order {
    public int orderNumber;
    public List<OrderItem> orderItems ;
    public double totalPrice;

    public Order(List<OrderItem> orderItems) {
        this.orderNumber = new Random().nextInt(100000) + 1;
        this.orderItems = orderItems;
        this.totalPrice = getTotalPrice();
    }

    public double getTotalPrice() {
        return orderItems.stream().mapToDouble(OrderItem::getPrice).sum();
    }
}
