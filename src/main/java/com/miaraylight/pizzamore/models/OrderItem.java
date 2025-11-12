package com.miaraylight.pizzamore.models;

public abstract class OrderItem {
    public String name;
    public String size;
    public double price;

    public OrderItem(String name, String size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrize(double price) {
        this.price = price;
    }

    public abstract double calculatePrice();

    public double getPrice() {
        this.price = calculatePrice();
        return price;
    }
}
