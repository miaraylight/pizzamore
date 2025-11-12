package com.miaraylight.pizzamore.models;

public class Drink extends OrderItem{
    private static final double SMALL_DRINK_PRICE = 2.00;
    private static final double MEDIUM_DRINK_PRICE = 2.50;
    private static final double LARGE_DRINK_PRICE = 3.00;

    public Drink(String name, Size size) {
        super(name, size, 0.0);
        setPrice(calculatePrice());
    }

    @Override
    public double calculatePrice() {
        return switch (getSize()) {
            case SMALL -> SMALL_DRINK_PRICE;
            case MEDIUM -> MEDIUM_DRINK_PRICE;
            case LARGE -> LARGE_DRINK_PRICE;
            default -> MEDIUM_DRINK_PRICE;
        };
    }
}
