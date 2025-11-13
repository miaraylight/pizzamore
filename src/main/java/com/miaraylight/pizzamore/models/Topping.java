package com.miaraylight.pizzamore.models;

public class Topping {
    private ToppingName name;
    private ToppingCategory category;
    private double price;

    public Topping(ToppingName name, ToppingCategory category) {
        this.name = name;
        this.category = category;
    }

    public ToppingName getName() {
        return name;
    }

    public void setName(ToppingName name) {
        this.name = name;
    }

    public ToppingCategory getCategory() {
        return category;
    }

    public void setCategory(ToppingCategory category) {
        this.category = category;
    }

    public enum ToppingName {
        PEPPERONI,
        SAUSAGE,
        HAM,
        BACON,
        CHICKEN,
        MEATBALL,

        // Cheese
        MOZZARELLA,
        PARMESAN,
        RICOTTA,
        GOAT_CHEESE,
        BUFFALO,

        // Regular toppings (no extra price)
        ONIONS,
        MUSHROOMS,
        BELL_PEPPERS,
        OLIVES,
        TOMATOES,
        SPINACH,
        BASIL,
        PINEAPPLE,
        ANCHOVIES;
    }

    public enum ToppingCategory {
        MEAT, CHEESE, REGULAR
    }
}