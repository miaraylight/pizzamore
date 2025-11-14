package com.miaraylight.pizzamore.ui;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserInterfaceTest {

    private final UserInterface ui = new UserInterface();
        @Test
        void testValidInputMultipleDigits() {
            String input = "12 , 3 a 4433";
            List<String> expected = List.of("1","2","3","4","4","3","3");
            assertEquals(expected, ui.getValidInput(input));
        }

        @Test
        void testValidInputWithSpacesAndLetters() {
            String input = " x0y6z ";
            List<String> expected = List.of("0","6");
            assertEquals(expected, ui.getValidInput(input));
        }

        @Test
        void testInputWithOnlyInvalidChars() {
            String input = "abcXYZ!@#";
            List<String> expected = List.of();
            assertEquals(expected, ui.getValidInput(input));
        }

        @Test
        void testEmptyString() {
            String input = "";
            List<String> expected = List.of();
            assertEquals(expected, ui.getValidInput(input));
        }

        @Test
        void testSingleDigit() {
            String input = "5";
            List<String> expected = List.of("5");
            assertEquals(expected, ui.getValidInput(input));
        }

}