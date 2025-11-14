package com.miaraylight.pizzamore.models;

public abstract class OrderItem {
    private String name;

    public OrderItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract double getPrice();

    public void setPrice(double price) {
    }
}
