package com.miaraylight.pizzamore.models;

public abstract class OrderItem {
    private String name;
    private Size size;
    private double price;

    public OrderItem(String name, Size size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculatePrice();

    public double getPrice() {
        this.price = calculatePrice();
        return price;
    }
}
