package com.miaraylight.pizzamore.models;

public class Drink extends OrderItem implements Sizable{
    private Size size;

    private static final double SMALL_DRINK_PRICE = 2.00;
    private static final double MEDIUM_DRINK_PRICE = 2.50;
    private static final double LARGE_DRINK_PRICE = 3.00;

    public Drink(String name, Size size) {
        super(name);
        this.size = size;
    }

    @Override
    public double getPrice() {
        return switch (getSize()) {
            case SMALL -> SMALL_DRINK_PRICE;
            case MEDIUM -> MEDIUM_DRINK_PRICE;
            case LARGE -> LARGE_DRINK_PRICE;
            default -> MEDIUM_DRINK_PRICE;
        };
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public void setSize(Size size) {
        this.size = size;
    }
}
