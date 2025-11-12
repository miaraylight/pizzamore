package com.miaraylight.pizzamore.models;

public class Bread extends OrderItem{
    public Bread(String name, Size size) {
        super(name, size, 0.0);
        setSize(Size.ONE_SIZE);
        setPrice(calculatePrice());
    }

    @Override
    public double calculatePrice() {
        return 1.50;
    }
}
