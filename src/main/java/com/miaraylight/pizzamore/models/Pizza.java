package com.miaraylight.pizzamore.models;

import java.util.List;

public class Pizza extends OrderItem {
    private String crustType;
    private String sauceType;
    private List<String> premiumToppings;
    private List<String> regularToppings;
    private List<String> cheese;
    private List<String> sides;

    public Pizza(String name, String size, String crustType, String sauceType, List<String> premiumToppings, List<String> regularToppings, List<String> cheese, List<String> sides) {
        super(name, size);
        this.crustType = crustType;
        this.sauceType = sauceType;
        this.premiumToppings = premiumToppings;
        this.regularToppings = regularToppings;
        this.cheese = cheese;
        this.sides = sides;
    }

    private double calculateCrustPrice() {
        return switch (size) {
            case "S" -> 8.50;
            case "M" -> 12.00;
            case "L" -> 16.50;
            default -> {
                System.out.println("⚠️ Unknown size '" + size + "', defaulting to medium price.");
                yield 12.50;
            }
        };
    }

    private double calculatePremiumToppingsPrice() {
        double totalPremiumToppingsPrice = switch (size) {
            case "S" -> 1.00;
            case "M" -> 2.00;
            case "L" -> 3.00;
            default -> {
                System.out.println("⚠️ Unknown size '" + size + "', defaulting to medium price.");
                yield 2.00;
            }
        };

        if (premiumToppings.size() >= 2) {
            for (int i = 1; i < premiumToppings.size(); i++) {
                totalPremiumToppingsPrice += switch (size) {
                    case "S" -> .50;
                    case "M" -> 1.00;
                    case "L" -> 1.75;
                    default -> {
                        System.out.println("⚠️ Unknown size '" + size + "', defaulting to medium price.");
                        yield 2.00;
                    }
                };
            }


        }
        return totalPremiumToppingsPrice;
    }

    @Override
    public double calculatePrice() {
        return 0;
    }
}
