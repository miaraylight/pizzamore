package com.miaraylight.pizzamore.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToppingTest {

    @Test
    void testFromInput_ValidNames() {
        // Exact match
        assertEquals(Topping.PEPPERONI, Topping.fromInput("Pepperoni"));
        assertEquals(Topping.MOZZARELLA, Topping.fromInput("Mozzarella"));

        // Different case
        assertEquals(Topping.BACON, Topping.fromInput("bacon"));
        assertEquals(Topping.HAM, Topping.fromInput("hAm"));

        // Leading/trailing spaces
        assertEquals(Topping.CHICKEN, Topping.fromInput("  Chicken  "));
    }

    @Test
    void testFromInput_InvalidNames() {
        assertNull(Topping.fromInput("Pine"));      // partial string
        assertNull(Topping.fromInput("Chocolate")); // not a topping
        assertNull(Topping.fromInput(""));          // empty string
        assertNull(Topping.fromInput(null));        // null input
        assertNull(Topping.fromInput("123"));       // numbers
    }

    @Test
    void testFromInput_AllToppings() {
        // Ensure every enum label maps correctly
        for (Topping t : Topping.values()) {
            assertEquals(t, Topping.fromInput(t.getLabel()));
        }
    }
}