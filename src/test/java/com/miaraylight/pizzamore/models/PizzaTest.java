package com.miaraylight.pizzamore.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {

    private Pizza smallPizza;
    private Pizza mediumPizza;
    private Pizza largePizza;

    private Topping pepperoni = Topping.PEPPERONI;
    private Topping sausage = Topping.SAUSAGE;
    private Topping ham = Topping.HAM;
    private Topping mozzarella = Topping.MOZZARELLA;
    private Topping parmesan = Topping.PARMESAN;

    @BeforeEach
    void setUp() {
        smallPizza = new Pizza("Small Pizza", Size.SMALL, CrustType.THIN, SauceType.MARINARA, null, null);
        mediumPizza = new Pizza("Medium Pizza", Size.MEDIUM, CrustType.THIN, SauceType.MARINARA, null, null);
        largePizza = new Pizza("Large Pizza", Size.LARGE, CrustType.THIN, SauceType.MARINARA, null, null);
    }

    @Test
    void testSmallPizzaSinglePremiumTopping() {
        smallPizza.addTopping(pepperoni);

        double expected = pepperoni.getBasePrice(); // only one premium, full price
        assertEquals(expected, smallPizza.getToppingsPrice());
    }

    @Test
    void testSmallPizzaMultiplePremiumToppings() {
        smallPizza.addTopping(pepperoni);
        smallPizza.addTopping(sausage);

        double expected = pepperoni.getBasePrice() + (sausage.getBasePrice() * 0.5); // first full, second 50%
        assertEquals(expected, smallPizza.getToppingsPrice());
    }

    @Test
    void testSmallPizzaPremiumAndCheeseToppings() {
        smallPizza.addTopping(pepperoni);
        smallPizza.addTopping(sausage);
        smallPizza.addTopping(mozzarella);
        smallPizza.addTopping(parmesan);

        double expected =
                pepperoni.getBasePrice() + (sausage.getBasePrice() * 0.5) +
                        mozzarella.getBasePrice() + (parmesan.getBasePrice() * 0.4);

        assertEquals(expected, smallPizza.getToppingsPrice());
    }

    @Test
    void testMediumPizzaPremiumTopping() {
        mediumPizza.addTopping(pepperoni);

        double expected = pepperoni.getBasePrice() * 2; // medium multiplier
        assertEquals(expected, mediumPizza.getToppingsPrice());
    }

    @Test
    void testMediumPizzaMultiplePremiumToppings() {
        mediumPizza.addTopping(pepperoni);
        mediumPizza.addTopping(sausage);

        double first = pepperoni.getBasePrice() * 2;
        double second = first * 0.5;
        double expected = first + second;

        assertEquals(expected, mediumPizza.getToppingsPrice());
    }

    @Test
    void testLargePizzaPremiumAndCheeseToppings() {
        largePizza.addTopping(pepperoni);
        largePizza.addTopping(sausage);
        largePizza.addTopping(mozzarella);
        largePizza.addTopping(parmesan);

        double firstPremium = pepperoni.getBasePrice() * 3;
        double secondPremium = firstPremium * 0.5;

        double firstCheese = mozzarella.getBasePrice() * 3;
        double secondCheese = firstCheese * 0.4;

        double expected = firstPremium + secondPremium + firstCheese + secondCheese;

        assertEquals(expected, largePizza.getToppingsPrice());
    }

    @Test
    void testPizzaNoToppings() {
        assertEquals(0.0, smallPizza.getToppingsPrice());
        assertEquals(0.0, mediumPizza.getToppingsPrice());
        assertEquals(0.0, largePizza.getToppingsPrice());
    }
}