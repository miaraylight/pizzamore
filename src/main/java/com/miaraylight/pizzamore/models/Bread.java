package com.miaraylight.pizzamore.models;

public class Bread extends OrderItem{
    public Bread(String name, String size) {
        super(name, size);
        this.price = calculatePrice();
    }

    @Override
    public double calculatePrice() {
        return 1.50;
    }
}
