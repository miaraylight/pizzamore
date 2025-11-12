package com.miaraylight.pizzamore.models;

public class Drink extends OrderItem{

    public Drink(String name, String size) {
        super(name, size);
        this.price = calculatePrice();
    }

    public double calculatePrice() {
        switch (size) {
            case "S":
                return 2.00;
            case "M":
                return 2.50;
            case "L":
                return 3.00;
            default:
                System.out.println("⚠️ Unknown size '" + size + "', defaulting to medium price.");
                return 2.50;
        }
    }
}
