package com.miaraylight.pizzamore.models;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends OrderItem implements Sizable {
    // Crust
    private static final double SMALL_CRUST_PRICE = 8.50;
    private static final double MEDIUM_CRUST_PRICE = 12.00;
    private static final double LARGE_CRUST_PRICE = 16.50;
    private Size size;
    private CrustType crustType;
    private SauceType sauceType;
    private List<Topping> toppings;
    private List<String> sides;

    public Pizza(String name, Size size, CrustType crustType, SauceType sauceType, List<Topping> toppings, List<String> sides) {
        super(name);
        this.size = size;
        this.crustType = crustType;
        this.sauceType = sauceType;
        this.toppings = toppings != null ? toppings : new ArrayList<>();
        this.sides = sides != null ? sides : new ArrayList<>();
        ;
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public void setSize(Size size) {
        this.size = size;
    }

    public CrustType getCrustType() {
        return crustType;
    }

    public void setCrustType(CrustType crustType) {
        this.crustType = crustType;
    }

    public SauceType getSauceType() {
        return sauceType;
    }

    public void setSauceType(SauceType sauceType) {
        this.sauceType = sauceType;
    }

    public List<String> getSides() {
        return sides;
    }

    public void addSide(String side) {
        sides.add(side);
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void removeTopping(Topping topping) {
        toppings.remove(topping); // removes first occurrence
    }

    public List<Topping> getToppingsByCategory(Topping.ToppingCategory category) {
        return toppings.stream().filter(topping -> topping.getCategory().equals(category)).toList();
    }

    public List<Topping> getToppings() {
        return toppings;
    }


    private double getCrustPrice() {
        return switch (getSize()) {
            case SMALL -> SMALL_CRUST_PRICE;
            case MEDIUM -> MEDIUM_CRUST_PRICE;
            case LARGE -> LARGE_CRUST_PRICE;
            default -> MEDIUM_CRUST_PRICE;
        };
    }

    public double getToppingsPrice() {
        if (toppings.isEmpty()) return 0.0;

        List<Topping> premium = toppings.stream().filter(topping -> topping.getCategory().equals(Topping.ToppingCategory.PREMIUM)).toList();
        List<Topping> cheese = toppings.stream().filter(topping -> topping.getCategory().equals(Topping.ToppingCategory.CHEESE)).toList();

        // size multiplier: S=1, M=2, L=3
        int multiplier = switch (getSize()) {
            case SMALL -> 1;
            case MEDIUM -> 2;
            case LARGE -> 3;
        };

        double total = 0.0;

        // PREMIUM: 1st = full, rest = 50%
        if (!premium.isEmpty()) {
            double base = premium.get(0).getBasePrice() * multiplier;
            total += base;

            for (int i = 1; i < premium.size(); i++) {
                total += base * 0.5;
            }
        }

        // CHEESE: 1st = full, rest = 40%
        if (!cheese.isEmpty()) {
            double base = cheese.get(0).getBasePrice() * multiplier;
            total += base;

            for (int i = 1; i < cheese.size(); i++) {
                total += base * 0.4;
            }
        }

        return total;
    }

    @Override
    public double getPrice() {
        return getCrustPrice() + getToppingsPrice();
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "size=" + size +
                ", crustType=" + crustType +
                ", sauceType=" + sauceType +
                ", toppings=" + toppings +
                ", sides=" + sides +
                '}';
    }
}
