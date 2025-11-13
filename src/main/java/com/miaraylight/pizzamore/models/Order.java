package com.miaraylight.pizzamore.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {
    private int orderNumber;
    private List<OrderItem> orderItems ;
    private double totalPrice;

    public Order() {
        this.orderNumber = new Random().nextInt(100000) + 1;
        this.orderItems = new ArrayList<>();
        this.totalPrice = getTotalPrice();
    }

    public double getTotalPrice() {
        return orderItems.stream().mapToDouble(OrderItem::getPrice).sum();
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public OrderItem addToOrder(OrderItem orderItem) {
        orderItems.add(orderItem);
        return orderItem;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", orderItems=" + orderItems +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
