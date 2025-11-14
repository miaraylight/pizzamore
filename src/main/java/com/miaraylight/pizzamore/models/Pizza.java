package com.miaraylight.pizzamore.models;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends OrderItem implements Sizable{
    private Size size;
    private CrustType crustType;
    private SauceType sauceType;
    private List<Topping> toppings;
    private List<String> sides;
    // Crust
    private static final double SMALL_CRUST_PRICE = 8.50;
    private static final double MEDIUM_CRUST_PRICE = 12.00;
    private static final double LARGE_CRUST_PRICE = 16.50;
    // Meats
    private static final double SMALL_MEAT_PRICE = 1.00;
    private static final double MEDIUM_MEAT_PRICE = 2.00;
    private static final double LARGE_MEAT_PRICE = 3.00;
    // Cheese
    private static final double SMALL_CHEESE_PRICE = 0.75;
    private static final double MEDIUM_CHEESE_PRICE = 1.50;
    private static final double LARGE_CHEESE_PRICE = 2.25;


    public Pizza(String name, Size size, CrustType crustType, SauceType sauceType, List<Topping> toppings, List<String> sides) {
        super(name);
        this.size = size;
        this.crustType = crustType;
        this.sauceType = sauceType;
        this.toppings = toppings != null ? toppings : new ArrayList<>();
        this.sides = sides != null ? sides : new ArrayList<>();;
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

    public void addSide(String side) {
        sides.add(side);
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }


    private double getCrustPrice() {
        return switch (getSize()) {
            case SMALL -> SMALL_CRUST_PRICE;
            case MEDIUM -> MEDIUM_CRUST_PRICE;
            case LARGE -> LARGE_CRUST_PRICE;
            default -> MEDIUM_CRUST_PRICE;
        };
    }

    private double getToppingsPrice() {
        if (toppings.isEmpty()) return 0.0;

        double total = 0.0;

        List<Topping> premium = toppings.stream().filter(topping -> topping.getCategory().equals(Topping.ToppingCategory.PREMIUM)).toList();
        List<Topping> cheese = toppings.stream().filter(topping -> topping.getCategory().equals(Topping.ToppingCategory.CHEESE)).toList();


        switch (getSize()) {
            case SMALL -> {
                if (!premium.isEmpty()) {
                    // first topping full price
                    total += premium.get(0).getBasePrice();

                    // rest at 50% price
                    for (int i = 1; i < premium.size(); i++) {
                        total += premium.get(i).getBasePrice() * 0.5;
                    }
                }

                if (!cheese.isEmpty()) {
                    // first cheese full price
                    total += cheese.get(0).getBasePrice();

                    // rest at 40%
                    for (int i = 1; i < cheese.size(); i++) {
                        total += cheese.get(i).getBasePrice() * 0.4;
                    }
                }
            }
            case MEDIUM -> {
                if (!premium.isEmpty()) {
                    // first topping full price
                    double basePriceForMedium = premium.get(0).getBasePrice() * 2; // when M is twice of base price
                    total += basePriceForMedium;

                    // rest at 50% price
                    for (int i = 1; i < premium.size(); i++) {
                        total += basePriceForMedium * 0.5;
                    }
                }

                if (!cheese.isEmpty()) {
                    // first cheese full price
                    double basePriceForMedium = premium.get(0).getBasePrice() * 2;
                    total += basePriceForMedium;

                    // rest at 40%
                    for (int i = 1; i < cheese.size(); i++) {
                        total += basePriceForMedium * 0.4;
                    }
                }
            }
            case LARGE -> {
                if (!premium.isEmpty()) {
                    // first topping full price
                    double basePriceForMedium = premium.get(0).getBasePrice() * 3; // when M is twice of base price
                    total += basePriceForMedium;

                    // rest at 50% price
                    for (int i = 1; i < premium.size(); i++) {
                        total += basePriceForMedium * 0.5;
                    }
                }

                if (!cheese.isEmpty()) {
                    // first cheese full price
                    double basePriceForMedium = premium.get(0).getBasePrice() * 3;
                    total += basePriceForMedium;

                    // rest at 40%
                    for (int i = 1; i < cheese.size(); i++) {
                        total += basePriceForMedium * 0.4;
                    }
                }
            }

            // regular toppings are free ( for now )
        }
        return total;
    }


//    private double getToppingsPrice() {
//        if (toppings.isEmpty()) return 0.0;
//
//        List<Topping> premiumToppings = toppings.stream().filter(topping -> topping.getCategory().equals(Topping.ToppingCategory.PREMIUM)).toList();
//        List<Topping> cheeseToppings = toppings.stream().filter(topping -> topping.getCategory().equals(Topping.ToppingCategory.CHEESE)).toList();
//
//        double totalToppingsPrice = 0.0;
//
//        switch (getSize()) {
//            case SMALL -> {
//                totalToppingsPrice = SMALL_MEAT_PRICE + ((premiumToppings.size() - 1 * SMALL_MEAT_PRICE) * 0.5) +
//                        SMALL_CHEESE_PRICE + ((cheeseToppings.size() - 1 * SMALL_CHEESE_PRICE) * 0.4);}
//            case MEDIUM -> {
//                totalToppingsPrice = MEDIUM_MEAT_PRICE + ((premiumToppings.size() - 1 * MEDIUM_MEAT_PRICE) * 0.5) +
//                        MEDIUM_CHEESE_PRICE + ((cheeseToppings.size() - 1 * MEDIUM_CHEESE_PRICE) * 0.4);}
//            case LARGE -> {
//                totalToppingsPrice = LARGE_MEAT_PRICE + ((premiumToppings.size() - 1 * LARGE_MEAT_PRICE) * 0.5) +
//                        LARGE_CHEESE_PRICE + ((cheeseToppings.size() - 1 * LARGE_CHEESE_PRICE) * 0.4);}
//
//        }
//
//        return totalToppingsPrice;
//
//    }

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
