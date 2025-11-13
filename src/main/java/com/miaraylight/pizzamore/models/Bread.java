package com.miaraylight.pizzamore.models;

public class Bread extends OrderItem{
    public Bread(String name) {
        super(name);
    }

    @Override
    public double getPrice() {
        return 1.50;
    }
}
