package com.miaraylight.pizzamore.models;

import java.util.ArrayList;
import java.util.List;



public class Pizza extends OrderItem implements Sizable{
    private Size size;
    private String crustType;
    private String sauceType;
    private List<String> premiumToppings;
    private List<String> regularToppings;
    private List<String> cheese;
    private List<String> sides;

    public static final String[] PREMIUM_TOPPINGS_OPTIONS = {
            "Pepperoni", "Sausage", "Ham", "Bacon", "Chicken", "Meatball"
    };

    public static final String[] REGULAR_TOPPINGS_OPTIONS = {
            "Onions", "Mushrooms", "Bell Peppers", "Olives", "Tomatoes",
            "Spinach", "Basil", "Pineapple", "Anchovies"
    };

    public static final String[] CHEESE_OPTIONS = {
            "Mozzarella", "Parmesan", "Ricotta", "Goat Cheese", "Buffalo"
    };

    private static final double SMALL_CRUST_PRICE = 8.50;
    private static final double MEDIUM_CRUST_PRICE = 12.00;
    private static final double LARGE_CRUST_PRICE = 16.50;

    // Meats
    private static final double SMALL_MEAT_PRICE = 1.00;
    private static final double MEDIUM_MEAT_PRICE = 2.00;
    private static final double LARGE_MEAT_PRICE = 3.00;

    private static final double SMALL_EXTRA_MEAT = 0.50;
    private static final double MEDIUM_EXTRA_MEAT = 1.00;
    private static final double LARGE_EXTRA_MEAT = 1.50;

    // Cheese
    private static final double SMALL_CHEESE_PRICE = 0.75;
    private static final double MEDIUM_CHEESE_PRICE = 1.50;
    private static final double LARGE_CHEESE_PRICE = 2.25;

    private static final double SMALL_EXTRA_CHEESE = 0.30;
    private static final double MEDIUM_EXTRA_CHEESE = 0.60;
    private static final double LARGE_EXTRA_CHEESE = 0.90;

    public Pizza(String name) {
        super(name);
        this.premiumToppings = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        this.cheese = new ArrayList<>();
        this.sides = new ArrayList<>();
    }

    public Pizza(String name, Size size, String crustType, String sauceType, List<String> premiumToppings, List<String> regularToppings, List<String> cheese, List<String> sides) {
        super(name);
        this.size = size;
        this.crustType = crustType;
        this.sauceType = sauceType;
        this.premiumToppings = premiumToppings;
        this.regularToppings = regularToppings;
        this.cheese = cheese;
        this.sides = sides;
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public void setSize(Size size) {
        this.size = size;
    }

    public String getCrustType() {
        return crustType;
    }

    public void setCrustType(String crustType) {
        this.crustType = crustType;
    }

    public String getSauceType() {
        return sauceType;
    }

    public void setSauceType(String sauceType) {
        this.sauceType = sauceType;
    }

    public boolean addRegularTopping(String regularTopping) {
        return regularToppings.add(regularTopping);
    }

    public boolean removeRegularTopping(String regularTopping) {
        return regularToppings.remove(regularTopping);
    }

    public boolean addPremiumTopping(String premiumTopping) {
        return premiumToppings.add(premiumTopping);
    }

    public boolean removePremiumTopping(String premiumTopping) {
        return premiumToppings.remove(premiumTopping);
    }

    public boolean addCheese(String cheeseType) {
        return cheese.add(cheeseType);
    }

    public boolean removeCheese(String cheeseType) {
        return cheese.remove(cheeseType);
    }

    private double getCrustPrice() {
        return switch (getSize()) {
            case SMALL -> SMALL_CRUST_PRICE;
            case MEDIUM -> MEDIUM_CRUST_PRICE;
            case LARGE -> LARGE_CRUST_PRICE;
            default -> MEDIUM_CRUST_PRICE;
        };
    }

    private double getPremiumToppingsPrice() {
        if (premiumToppings.isEmpty()) return 0.0;

        double premiumToppingPrice = 0.0, extraToppingPrice = 0.0;

        switch (getSize()) {
            case SMALL -> {premiumToppingPrice = SMALL_MEAT_PRICE; extraToppingPrice = SMALL_EXTRA_MEAT;}
            case MEDIUM -> {premiumToppingPrice = MEDIUM_MEAT_PRICE; extraToppingPrice = MEDIUM_EXTRA_MEAT;}
            case LARGE -> {premiumToppingPrice = LARGE_MEAT_PRICE; extraToppingPrice = LARGE_EXTRA_MEAT;}
        }

        return premiumToppingPrice + ((premiumToppings.size() - 1) * extraToppingPrice);
    }

    private double getCheesePrice() {
        if(cheese.isEmpty()) return 0.0;

        double cheesePrize = 0.0, extraCheesePrize = 0.0;

        switch (getSize()) {
            case SMALL -> {cheesePrize = SMALL_CHEESE_PRICE; extraCheesePrize = SMALL_EXTRA_CHEESE;}
            case MEDIUM -> {cheesePrize = MEDIUM_CHEESE_PRICE; extraCheesePrize = MEDIUM_EXTRA_CHEESE;}
            case LARGE -> {cheesePrize = LARGE_CHEESE_PRICE; extraCheesePrize = LARGE_EXTRA_CHEESE;}
        }

        return cheesePrize + ((cheese.size() - 1) * extraCheesePrize);
    }

    @Override
    public double getPrice() {
        return getCrustPrice() + getPremiumToppingsPrice() + getCheesePrice();
    }

}
