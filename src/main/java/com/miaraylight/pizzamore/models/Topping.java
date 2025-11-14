package com.miaraylight.pizzamore.models;

public enum Topping {
    // Meats
    PEPPERONI("Pepperoni", ToppingCategory.PREMIUM, 1.00),
    SAUSAGE("Sausage", ToppingCategory.PREMIUM, 1.00),
    HAM("Ham", ToppingCategory.PREMIUM, 1.00),
    BACON("Bacon", ToppingCategory.PREMIUM, 1.00),
    CHICKEN("Chicken", ToppingCategory.PREMIUM, 1.00),
    MEATBALL("Meatball", ToppingCategory.PREMIUM, 1.00),

    // Cheese
    MOZZARELLA("Mozzarella", ToppingCategory.CHEESE, 0.75),
    PARMESAN("Parmesan", ToppingCategory.CHEESE, 0.75),
    RICOTTA("Ricotta", ToppingCategory.CHEESE, 0.75),
    GOAT_CHEESE("Goat Cheese", ToppingCategory.CHEESE, 0.75),
    BUFFALO("Buffalo", ToppingCategory.CHEESE, 0.75),

    // Regular toppings (no extra price)
    ONIONS("Onions", ToppingCategory.REGULAR, 0.00),
    MUSHROOMS("Mushrooms", ToppingCategory.REGULAR, 0.00),
    BELL_PEPPERS("Bell Peppers", ToppingCategory.REGULAR, 0.00),
    OLIVES("Olives", ToppingCategory.REGULAR, 0.00),
    TOMATOES("Tomatoes", ToppingCategory.REGULAR, 0.00),
    SPINACH("Spinach", ToppingCategory.REGULAR, 0.00),
    BASIL("Basil", ToppingCategory.REGULAR, 0.00),
    PINEAPPLE("Pineapple", ToppingCategory.REGULAR, 0.00),
    ANCHOVIES("Anchovies", ToppingCategory.REGULAR, 0.00);

    private final String label;
    private final ToppingCategory category;
    private final double basePrice;

    // Constructor for meats and cheese
    Topping(String label, ToppingCategory category, double basePrice) {
        this.label = label;
        this.category = category;
        this.basePrice = basePrice;
    }

    // Constructor for regular toppings
    Topping(String label, ToppingCategory category) {
        this(label, category, 0.0);
    }

    public String getLabel() {
        return label;
    }

    public ToppingCategory getCategory() {
        return category;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public static Topping fromInput(String input) {
        if (input == null) return null;
        input = input.trim().toUpperCase();

        for (Topping t : values()) {// so enum creates array of its known enums
            if (t.label.toUpperCase().equals(input)) {
                return t;
            }
        }

        return null; // not found
    }

    @Override
    public String toString() {
        return label;
    }

        public enum ToppingCategory {
        PREMIUM, CHEESE, REGULAR
    }
}



//public class Topping {
//    private ToppingName name;
//    private ToppingCategory category;
//    private double price;
//
//    public Topping(ToppingName name, ToppingCategory category) {
//        this.name = name;
//        this.category = category;
//    }
//
//    public ToppingName getName() {
//        return name;
//    }
//
//    public void setName(ToppingName name) {
//        this.name = name;
//    }
//
//    public ToppingCategory getCategory() {
//        return category;
//    }
//
//    public void setCategory(ToppingCategory category) {
//        this.category = category;
//    }
//
//    public enum ToppingName {
//        PEPPERONI,
//        SAUSAGE,
//        HAM,
//        BACON,
//        CHICKEN,
//        MEATBALL,
//
//        // Cheese
//        MOZZARELLA,
//        PARMESAN,
//        RICOTTA,
//        GOAT_CHEESE,
//        BUFFALO,
//
//        // Regular toppings (no extra price)
//        ONIONS,
//        MUSHROOMS,
//        BELL_PEPPERS,
//        OLIVES,
//        TOMATOES,
//        SPINACH,
//        BASIL,
//        PINEAPPLE,
//        ANCHOVIES;
//    }
//
//    public enum ToppingCategory {
//        PREMIUM, CHEESE, REGULAR
//    }
//}