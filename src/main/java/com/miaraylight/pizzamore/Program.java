package com.miaraylight.pizzamore;

import com.miaraylight.pizzamore.models.*;
import com.miaraylight.pizzamore.ui.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        System.out.println("My pizzeria");

        List<String> meats = List.of("Pepperoni", "Bacon", "Sausage"); // 1 main + 2 extras
        List<String> cheese = List.of("Mozzarella", "Parmesan"); // 1 main + 1 extra
        List<String> regular = List.of("Onions", "Mushrooms", "Olives");

        Pizza pizza = new Pizza(
                "Custom Pizza",
                Size.SMALL,
                "Thin",
                "Marinara",
                meats,
                regular,
                cheese,
                List.of("Parmesan")
        );

        Drink drink = new Drink("Orange juice", Size.SMALL);
        Bread bread = new Bread("Garlic knots");
        System.out.printf("Your pizza costs: $%.2f%n", pizza.getPrice());
        System.out.printf("Your drink costs: $%.2f%n", drink.getPrice());
        System.out.printf("Your bread costs: $%.2f%n", bread.getPrice());

        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(pizza);
        orderItems.add(drink);
        orderItems.add(bread);

        Order order = new Order();
        order.setOrderItems(orderItems);

        System.out.println(order.getTotalPrice());

//        UserInterface userInterface = new UserInterface();
//        userInterface.display();
    }
}
