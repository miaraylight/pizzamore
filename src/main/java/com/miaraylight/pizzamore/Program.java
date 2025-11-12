package com.miaraylight.pizzamore;

import com.miaraylight.pizzamore.ui.UserInterface;

public class Program {
    public static void main(String[] args) {
        System.out.println("My pizzeria");

        UserInterface userInterface = new UserInterface();
        userInterface.display();
    }
}
