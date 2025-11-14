package com.miaraylight.pizzamore.ui;

import com.miaraylight.pizzamore.models.*;
import com.miaraylight.pizzamore.util.ReceiptWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.miaraylight.pizzamore.ui.AnsiColors.*;

public class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);
    private Order order;

    // display
    public static void displayMainMenu() {
        System.out.println(BOLD + CYAN + "╔════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "                   Main Menu                 " + RESET);
        System.out.println(CYAN + "╠════════════════════════════════════════════╣" + RESET);
        System.out.println("  " + GREEN + "[1]" + RESET + " 🍕 Order");
        System.out.println("  " + MAGENTA + "[0]" + RESET + " ❌ Cancel / Exit");
        System.out.println(CYAN + "╚════════════════════════════════════════════╝" + RESET);
    }

    public static void displayOrderMenu() {
        System.out.println(BOLD + CYAN + "╔════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "               Add to Your Order             " + RESET);
        System.out.println(CYAN + "╠════════════════════════════════════════════╣" + RESET);
        System.out.println("  " + GREEN + "[P]" + RESET + " 🍕 Pizza");
        System.out.println("  " + GREEN + "[D]" + RESET + " 🥤 Drinks");
        System.out.println("  " + GREEN + "[B]" + RESET + " 🧄 Bread");
        System.out.println("  " + GREEN + "[F]" + RESET + " 💳 Pay Now");
        System.out.println("  " + MAGENTA + "[X]" + RESET + " 🔙 Cancel");
        System.out.println(CYAN + "╚════════════════════════════════════════════╝" + RESET);
    }

    public static void displayPizzaMenu() {
        System.out.println(BOLD + CYAN + "╔════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "               Choose Your Pizza Type        " + RESET);
        System.out.println(CYAN + "╠════════════════════════════════════════════╣" + RESET);
        System.out.println("  " + GREEN + "[S]" + RESET + " ⭐ Signature Pizza");
        System.out.println("  " + GREEN + "[V]" + RESET + " 🥦 Veggie Pizza");
        System.out.println("  " + GREEN + "[M]" + RESET + " 🍳 Build My Own Pizza");
        System.out.println("  " + MAGENTA + "[X]" + RESET + " 🔙 Go Back");
        System.out.println(CYAN + "╚════════════════════════════════════════════╝" + RESET);
    }

    public static void displayBuildPizzaMenu() {
        System.out.println(BOLD + CYAN + "╔════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "             Customize Your Pizza            " + RESET);
        System.out.println(CYAN + "╠════════════════════════════════════════════╣" + RESET);
        System.out.println("  " + GREEN + "[1]" + RESET + " 📏 Size");
        System.out.println("  " + GREEN + "[2]" + RESET + " 🍞 Crust Type");
        System.out.println("  " + GREEN + "[3]" + RESET + " 🍅 Sauce");
        System.out.println("  " + GREEN + "[4]" + RESET + " 🍖 Protein");
        System.out.println("  " + GREEN + "[5]" + RESET + " 🥦 Toppings");
        System.out.println("  " + GREEN + "[6]" + RESET + " 🧀 Cheese");
        System.out.println("  " + GREEN + "[7]" + RESET + " 🍽️ Sides");
        System.out.println("  " + GREEN + "[8]" + RESET + " ✅ Done");
        System.out.println("  " + MAGENTA + "[0]" + RESET + " ❌ Go Back");
        System.out.println(CYAN + "╚════════════════════════════════════════════╝" + RESET);
    }

    public static void displayPizzaSizeMenu() {
        System.out.println(BOLD + CYAN + "╔════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "              Choose Your Pizza Size         " + RESET);
        System.out.println(CYAN + "╠════════════════════════════════════════════╣" + RESET);
        System.out.println("  " + GREEN + "[S]" + RESET + " 🍕 Small (8\")");
        System.out.println("  " + GREEN + "[M]" + RESET + " 🍕🍕 Medium (12\")");
        System.out.println("  " + GREEN + "[L]" + RESET + " 🍕🍕🍕 Large (16\")");
        System.out.println(CYAN + "╚════════════════════════════════════════════╝" + RESET);
    }

    public static void displayPizzaCrustMenu() {
        System.out.println(BOLD + CYAN + "╔════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "              Choose Your Pizza Crust        " + RESET);
        System.out.println(CYAN + "╠════════════════════════════════════════════╣" + RESET);
        System.out.println("  " + GREEN + "[1]" + RESET + " 🍞 Thin");
        System.out.println("  " + GREEN + "[2]" + RESET + " 🍞 Regular");
        System.out.println("  " + GREEN + "[3]" + RESET + " 🍞 Thick");
        System.out.println("  " + GREEN + "[4]" + RESET + " 🥦 Cauliflower");
        System.out.println(CYAN + "╚════════════════════════════════════════════╝" + RESET);
    }

    public static void displayPizzaSauceMenu() {
        System.out.println(BOLD + CYAN + "╔════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "                 Choose Your Sauce           " + RESET);
        System.out.println(CYAN + "╠════════════════════════════════════════════╣" + RESET);
        System.out.println("  " + GREEN + "[1]" + RESET + " 🍅 Marinara");
        System.out.println("  " + GREEN + "[2]" + RESET + " 🧄 Alfredo");
        System.out.println("  " + GREEN + "[3]" + RESET + " 🌿 Pesto");
        System.out.println("  " + GREEN + "[4]" + RESET + " 🍖 BBQ");
        System.out.println("  " + GREEN + "[5]" + RESET + " 🌶️ Buffalo");
        System.out.println("  " + GREEN + "[6]" + RESET + " 🫒 Olive Oil");
        System.out.println(CYAN + "╚════════════════════════════════════════════╝" + RESET);
    }

    public static void displayToppingMenu(List<Topping> toppings, Topping.ToppingCategory category) {

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("            " + category.name());
        System.out.println("╠════════════════════════════════════════════╣");
        for (int i = 0; i < toppings.size(); i++) {
            System.out.printf("  [%d] %s%n", i + 1, toppings.get(i).getLabel());
        }
        System.out.println("  [0] No selection");
        System.out.println("╚════════════════════════════════════════════╝");
    }

    public static void displaySidesMenu() {
        System.out.println(BOLD + CYAN + "╔════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "                 Choose Your Sides           " + RESET);
        System.out.println(CYAN + "╠════════════════════════════════════════════╣" + RESET);
        System.out.println("  " + GREEN + "[1]" + RESET + " 🌶️ Red Pepper");
        System.out.println("  " + GREEN + "[2]" + RESET + " 🧂 Parmesan");
        System.out.println("  " + GREEN + "[0]" + RESET + " 🚫 No Sides");
        System.out.println(CYAN + "╚════════════════════════════════════════════╝" + RESET);
    }

    public static void displayDrinksMenu() {
        System.out.println(BOLD + CYAN + "╔════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "                Choose Your Drinks           " + RESET);
        System.out.println(CYAN + "╠════════════════════════════════════════════╣" + RESET);
        System.out.println("  " + GREEN + "[1]" + RESET + " 🥤 Smoothie");
        System.out.println("  " + GREEN + "[2]" + RESET + " 🍊 Orange Juice");
        System.out.println("  " + GREEN + "[0]" + RESET + " 🚫 No Drink");
        System.out.println(CYAN + "╚════════════════════════════════════════════╝" + RESET);
    }

    public static void displayBreadMenu() {
        System.out.println(BOLD + CYAN + "╔════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "               Choose your bread side        " + RESET);
        System.out.println(CYAN + "╠════════════════════════════════════════════╣" + RESET);
        System.out.println("  " + GREEN + "[1]" + RESET + " 🥖 Garlic Knots");
        System.out.println("  " + GREEN + "[2]" + RESET + " 🍞 Bread sticks");
        System.out.println("  " + GREEN + "[3]" + RESET + " 🧄 Loaded tots");
        System.out.println("  " + MAGENTA + "[0]" + RESET + " 🚫 No Bread / Go Back");
        System.out.println(CYAN + "╚════════════════════════════════════════════╝" + RESET);
    }

    public static void displaySizeMenu() {
        System.out.println(BOLD + CYAN + "╔════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "                Choose a size               " + RESET);
        System.out.println(CYAN + "╠════════════════════════════════════════════╣" + RESET);
        System.out.println("  " + GREEN + "[S]" + RESET + " Small");
        System.out.println("  " + GREEN + "[M]" + RESET + " Medium");
        System.out.println("  " + GREEN + "[L]" + RESET + " Large");
        System.out.println(CYAN + "╚════════════════════════════════════════════╝" + RESET);
    }

    // helpers
    public static String getUserInput(String prompt) {
        System.out.print(prompt + " ");
        return scanner.nextLine().trim().toUpperCase();
    }

    public void initOrder() {
        this.order = new Order();
    }

    public void display() {
        displayLogo();
        int input;
        do {
            displayMainMenu();
            System.out.println("Enter your choice:");
            while (!scanner.hasNextInt()) {
                System.out.println("Enter a number please:");
                scanner.next();
            }

            input = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (input) {
                case 1:
                    initOrder();
                    runOrderMenu();
                    break;
                case 0:
                    System.out.println("Order cancelled");
                    break;
                default:
                    System.out.println("Invalid input. Try again");
            }
        } while (input != 0);
    }

    // run
    public void runOrderMenu() {
        boolean running = true;

        while (running) {
            if (!order.getOrderItems().isEmpty()) {
                displayCurrentOrder(order);
            }
            displayOrderMenu();
            System.out.println("What to get...");
            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "P":
                    runPizzaMenu();
                    break;
                case "D":
                    runDrinksMenu();
                    break;
                case "B":
                    runBreadMenu();
                    break;
                case "F":
                    if (!order.getOrderItems().isEmpty()) {
                        ReceiptWriter receiptWriter = new ReceiptWriter();
                        receiptWriter.writeReceipt(order);
                        System.out.println("Thank for choosing us! Enjoy!");
                    } else {
                        System.out.println("Cart is empty. Add some stuff.");
                    }

                case "X":
                    running = false;
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again");
            }
        }
    }

    public void runPizzaMenu() {
        boolean running = true;

        while (running) {
            displayPizzaMenu();
            System.out.println("Mmmm pizza...");
            System.out.println("Enter your choice: ");
            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "S":
                    System.out.println("Signature Pizza selected.");
                    Pizza signature = getSignaturePizza();

                    System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                    System.out.println("\nWould you like to customize it? (y/n)");
                    String customize = scanner.nextLine().trim();
                    if (customize.equalsIgnoreCase("y")) {
                        Pizza customizedSignature = runCustomizeMenu(signature);
                        order.addToOrder(customizedSignature);
                    } else if (customize.equalsIgnoreCase("n")) {
                        order.addToOrder(signature);
                    } else {
                        System.out.println("Invalid input. Try again");
                    }
                    break;
                case "V":
                    System.out.println("Veggie Pizza selected.");
                    Pizza veggie = getVeggiePizza();
                    System.out.println(getVeggiePizza());

                    System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                    System.out.println("Would you like to customize it? (y/n)");
                    String customizeVeggie = scanner.nextLine().trim();
                    if (customizeVeggie.equalsIgnoreCase("y")) {
                        Pizza customizedVeggie = runCustomizeMenu(veggie);
                        order.addToOrder(customizedVeggie);
                    } else if (customizeVeggie.equalsIgnoreCase("n")) {
                        order.addToOrder(veggie);
                    } else {
                        System.out.println("Invalid input. Try again");
                    }
                    break;
                case "M":
                    System.out.println("Let's build it!");
                    runBuildMenu();
                    break;
                case "X":
                    running = false;
                    System.out.println("Going back...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again");
            }
        }
    }

    private void runBuildMenu() {
        boolean running = true;
        Pizza myStylePizza = new Pizza("My style pizza", Size.MEDIUM, CrustType.REGULAR, SauceType.MARINARA, null, null); // default


        while (running) {
            displayPizza(myStylePizza);
            displayBuildPizzaMenu();
            System.out.print("What would you like to adjust?");
            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {

                // 🍕 PIZZA SIZE
                case 1:
                    myStylePizza.setSize(askForSize(UserInterface::displayPizzaSizeMenu));
                    System.out.println("✅ Selected size: " + myStylePizza.getSize());
                    break;

                // 🫓 CRUST
                case 2:
                    myStylePizza.setCrustType(askForCrustType(UserInterface::displayPizzaCrustMenu));
                    System.out.println("✅ Selected crust: " + myStylePizza.getCrustType());
                    break;

                // 🍅 SAUCE
                case 3:
                    displayPizzaSauceMenu();
                    myStylePizza.setSauceType(askForSauceType(UserInterface::displayPizzaSauceMenu));
                    System.out.println("✅ Selected sauce: " + myStylePizza.getSauceType());
                    break;

                // 🍖 PREMIUM TOPPINGS
                case 4:
                    buildToppings(myStylePizza, Topping.ToppingCategory.PREMIUM);
                    System.out.println("Added protein toppings:");
                    displayToppingMenu(myStylePizza.getToppingsByCategory(Topping.ToppingCategory.PREMIUM), Topping.ToppingCategory.PREMIUM);
                    break;

                // 🥦 REGULAR TOPPINGS
                case 5:
                    buildToppings(myStylePizza, Topping.ToppingCategory.REGULAR);
                    System.out.println("Added regular toppings:");
                    displayToppingMenu(myStylePizza.getToppingsByCategory(Topping.ToppingCategory.REGULAR), Topping.ToppingCategory.REGULAR);
                    break;

                // 🧀 CHEESE
                case 6:
                    buildToppings(myStylePizza, Topping.ToppingCategory.CHEESE);
                    System.out.println("Added CHEESE toppings:");
                    displayToppingMenu(myStylePizza.getToppingsByCategory(Topping.ToppingCategory.CHEESE), Topping.ToppingCategory.CHEESE);
                    break;

                // 🍽 SIDES
                case 7:
                    displaySidesMenu();
                    String sideInput = getUserInput("Choose side (1–2):");
                    String side = "";

                    switch (sideInput) {
                        case "1":
                            side = "Red Pepper";
                            break;
                        case "2":
                            side = "Parmesan";
                            break;
                        case "0":
                            side = "";
                            break;
                        default:
                            System.out.println("❌ Invalid side option.");
                            continue;
                    }

                    myStylePizza.addSide(side);
                    System.out.println("✅ Added side: " + side);
                    break;
                case 8:
                    //save pizza
                    order.addToOrder(myStylePizza);
                    System.out.println("Adding to your order...");
                    System.out.println("✅ Added!");
                    running = false;
                    // 🔙 EXIT
                case 0:
                    System.out.println("Returning to main menu...");
                    running = false;
                    break;

                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        }
    }

    private Pizza runCustomizeMenu(Pizza pizza) {
        boolean running = true;

        while (running) {
            displayBuildPizzaMenu();
            System.out.print("What would you like to customize? ");
            int input = scanner.nextInt();
            scanner.nextLine();


            switch (input) {

                // 🍕 PIZZA SIZE
                case 1:
                    pizza.setSize(askForSize(UserInterface::displayPizzaSizeMenu));
                    System.out.println("✅ Selected size: " + pizza.getSize());
                    break;

                // 🫓 CRUST
                case 2:
                    pizza.setCrustType(askForCrustType(UserInterface::displayPizzaCrustMenu));
                    System.out.println("✅ Selected crust: " + pizza.getCrustType());
                    break;

                // 🍅 SAUCE
                case 3:
                    displayPizzaSauceMenu();
                    pizza.setSauceType(askForSauceType(UserInterface::displayPizzaSauceMenu));
                    System.out.println("✅ Selected sauce: " + pizza.getSauceType());
                    break;
                // 🍖 TOPPINGS
                case 4:
                    customizeToppings(pizza, Topping.ToppingCategory.PREMIUM);
                    System.out.println("Updated toppings:");
                    displayToppingMenu(pizza.getToppingsByCategory(Topping.ToppingCategory.PREMIUM), Topping.ToppingCategory.PREMIUM);
                    break;

                // 🥦 REGULAR TOPPINGS
                case 5:
                    customizeToppings(pizza, Topping.ToppingCategory.REGULAR);
                    System.out.println("Updated toppings:");
                    displayToppingMenu(pizza.getToppingsByCategory(Topping.ToppingCategory.REGULAR), Topping.ToppingCategory.REGULAR);
                    break;

                // 🧀 CHEESE
                case 6:
                    customizeToppings(pizza, Topping.ToppingCategory.CHEESE);
                    System.out.println("Updated toppings:");
                    displayToppingMenu(pizza.getToppingsByCategory(Topping.ToppingCategory.CHEESE), Topping.ToppingCategory.CHEESE);
                    break;
                // 🍽 SIDES
                case 7:
                    displaySidesMenu();
                    String sideInput = getUserInput("Choose side (1–2):");
                    String side = "";

                    switch (sideInput) {
                        case "1":
                            side = "Red Pepper";
                            break;
                        case "2":
                            side = "Parmesan";
                            break;
                        case "0":
                            side = "";
                            break;
                        default:
                            System.out.println("❌ Invalid side option.");
                            continue;
                    }
                    System.out.println("✅ Added side: " + side);
                    break;
                case 8:
                    //save pizza
                    System.out.println("Adding to your order...");
                    System.out.println("Added!");
                    running = false;
                    // 🔙 EXIT
                case 0:
                    System.out.println("Returning to main menu...");
                    running = false;
                    break;

                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        }

        return pizza;
    }

    public void runDrinksMenu() {
        boolean running = true;

        while (running) {
            displayDrinksMenu();
            String choice = getUserInput("Choose a drink: ");

            if ("0".equals(choice)) {
                System.out.println("🚫 Returning to main menu...");
                running = false;
                break;
            }

            Drink drink = null;

            switch (choice) {
                case "1":
                    drink = new Drink("Smoothie", askForSize(UserInterface::displaySizeMenu));
                    System.out.println("🥤You chose Smoothie!");
                    break;
                case "2":
                    drink = new Drink("Orange Juice", askForSize(UserInterface::displaySizeMenu));
                    System.out.println("🍊 You chose Orange Juice!");
                    break;
                default:
                    System.out.println("❌ Invalid choice. Please try again.");
                    continue;
            }

            if (drink != null) {
                System.out.println("✅ Added " + drink.getSize() + " " + drink.getName() + " — Price: $ " + drink.getPrice());
                order.addToOrder(drink);
            }

            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
            String more = getUserInput("\nDo you want to add another drink? (y/n): ");
            if (!more.equalsIgnoreCase("y")) {
                running = false; // exit loop and return to main menu
            }
        }
        System.out.println("🛒 Returning to main menu");
    }

    public void runBreadMenu() {
        boolean running = true;

        while (running) {
            displayBreadMenu();
            String choice = getUserInput("Choose a bread option: ").trim().toUpperCase();

            if (choice.equals("0")) {
                System.out.println("🚫 Returning to main menu...");
                running = false;
                break;
            }

            Bread bread = null;

            switch (choice) {
                case "1":
                    bread = new Bread("Garlic Knots");
                    System.out.println("🥖 You chose Garlic Knots!");
                    break;
                case "2":
                    bread = new Bread("Bread sticks");
                    System.out.println("🍞 You chose Bread sticks!");
                    break;
                case "3":
                    bread = new Bread("Loaded Tots");
                    System.out.println("🧄 You chose Loaded Tots!");
                    break;
                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }

            if (bread != null) {
                System.out.println("✅ Added " + bread.getName() + " — Price: $" + bread.getPrice());
                order.addToOrder(bread);
            }

            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
            String more = getUserInput("\nDo you want to add another bread? (y/n):");
            if (!more.equalsIgnoreCase("y")) running = false;

        }

        System.out.println("🛒 Returning to main menu");
    }

    private void displayCurrentOrder(Order order) {
        List<OrderItem> items = order.getOrderItems();
        if (items.isEmpty()) {
            System.out.println("Your order is empty.");
            return;
        }

        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║                CURRENT ORDER ITEMS               ║");
        System.out.println("╠════╦══════════════════════╦══════════╦═══════════╣");
        System.out.println("║ #  ║ Item                 ║ Size     ║ Price     ║");
        System.out.println("╠════╬══════════════════════╬══════════╬═══════════╣");

        int index = 1;

        for (OrderItem item : items) {

            String size = (item instanceof Sizable s) ? s.getSize().toString() : "-";
            ;

            System.out.printf(
                    "║ %-3d║ %-20s ║ %-8s ║ $%8.2f ║%n",
                    index++,
                    item.getName(),
                    size,
                    item.getPrice()
            );
        }

        System.out.println("╠════╩══════════════════════╩══════════╬═══════════╣");

        // FINAL TOTAL ROW — always last
        System.out.printf(
                "║ %-36s ║ $%8.2f ║%n",
                "SUBTOTAL:",
                order.getSubtotal()
        );

        System.out.println("╚══════════════════════════════════════════════════╝");
    }

    private void displayPizza(Pizza pizza) {
        System.out.println("Pizza Details:");
        System.out.println("--------------");

        System.out.println("Name       : " + pizza.getName());
        System.out.println("Size       : " + (pizza.getSize() != null ? pizza.getSize() : "-"));
        System.out.println("Crust Type : " + (pizza.getCrustType() != null ? pizza.getCrustType() : "-"));
        System.out.println("Sauce Type : " + (pizza.getSauceType() != null ? pizza.getSauceType() : "-"));

        // Display toppings grouped by category
        for (Topping.ToppingCategory category : Topping.ToppingCategory.values()) {
            List<Topping> toppings = pizza.getToppingsByCategory(category);
            if (!toppings.isEmpty()) {
                String toppingList = toppings.stream()
                        .map(Topping::getLabel)
                        .collect(Collectors.joining(", "));
                System.out.println(category.name() + " : " + toppingList);
            }
        }

        // Display sides if any
        if (!pizza.getSides().isEmpty()) {
            String sidesList = pizza.getSides().stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
            System.out.println("Sides      : " + sidesList);
        }

        System.out.printf("Total Price: $%.2f%n", pizza.getPrice());
    }

    private Size askForSize(Runnable displaySizeMenu) {
        displaySizeMenu();

        String sizeChoice = getUserInput("Enter size: ");

        return Size.fromInput(sizeChoice);

    }

    private CrustType askForCrustType(Runnable displayPizzaCrustMenu) {
        displayPizzaCrustMenu();

        String crustChoice = getUserInput("Enter crust type: ");

        return CrustType.fromInput(crustChoice);

    }

    private SauceType askForSauceType(Runnable displayPizzaSauceMenu) {
        displayPizzaSauceMenu();

        String sauceChoice = getUserInput("Enter sauce type: ");

        return SauceType.fromInput(sauceChoice);
    }

    public List<String> getValidInput(String input) {
        return input.chars()                     // stream of int (Unicode code points)
                .filter(Character::isDigit)                      // keep only digits
                .mapToObj(c -> String.valueOf((char) c))         // convert int to String
                .toList();
    }

    public Pizza getSignaturePizza() {
        List<Topping> signatureToppings = new ArrayList<>();

        signatureToppings.add(Topping.PEPPERONI);
        signatureToppings.add(Topping.SAUSAGE);
        signatureToppings.add(Topping.HAM);
        signatureToppings.add(Topping.BACON);

        signatureToppings.add(Topping.BELL_PEPPERS);
        signatureToppings.add(Topping.OLIVES);
        signatureToppings.add(Topping.TOMATOES);

        signatureToppings.add(Topping.MOZZARELLA);
        signatureToppings.add(Topping.PARMESAN);

        return new Pizza(
                "Signature",
                Size.MEDIUM,
                CrustType.REGULAR,
                SauceType.ALFREDO,
                signatureToppings,
                List.of("Red Pepper")
        );

    }

    public Pizza getVeggiePizza() {
        List<Topping> veggieToppings = new ArrayList<>();

        veggieToppings.add(Topping.BELL_PEPPERS);
        veggieToppings.add(Topping.OLIVES);
        veggieToppings.add(Topping.BASIL);

        veggieToppings.add(Topping.ONIONS);
        veggieToppings.add(Topping.MUSHROOMS);
        veggieToppings.add(Topping.SPINACH);

        veggieToppings.add(Topping.RICOTTA);

        return new Pizza(
                "Veggie",
                Size.MEDIUM,
                CrustType.CAULIFLOWER,
                SauceType.MARINARA,
                veggieToppings,
                List.of()
        );

    }

    public void buildToppings(Pizza pizza, Topping.ToppingCategory category) {
        // Get all toppings in this category
        List<Topping> available = Arrays.stream(Topping.values())
                .filter(t -> t.getCategory() == category)
                .toList();

        displayToppingMenu(available, category);

        // Get user input
        String addInput = getUserInput("Enter your choice(s) (e.g., 1 2 4): ");
        List<String> addedToppingCodes = getValidInput(addInput);

        if (addedToppingCodes.isEmpty()) {
            System.out.println("❌ No valid selection.");
            return;
        }

        // Process input
        for (String code : addedToppingCodes) {
            try {
                int index = Integer.parseInt(code) - 1; // convert to 0-based
                if (index >= 0 && index < available.size()) {
                    Topping topping = available.get(index);
                    pizza.addTopping(topping);
                    System.out.println("✅ Added: " + topping.getLabel());
                } else if (index == -1) {
                    System.out.println("🚫 Skipped " + category.name());
                } else {
                    System.out.println("❌ Invalid choice: " + code);
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input: " + code);
            }
        }
    }

    public void customizeToppings(Pizza pizza, Topping.ToppingCategory category) {
        // Get all toppings in this category
        List<Topping> available = Arrays.stream(Topping.values())
                .filter(t -> t.getCategory() == category)
                .toList();
        // show current
        List<Topping> currentToppings = pizza.getToppingsByCategory(category);
        System.out.println("Current toppings:");
        displayToppingMenu(currentToppings, category);

        System.out.println("Would you like to remove?");
        // Get user input
        String input = getUserInput("Enter your choice(s) (e.g., 1 2 4): ");
        List<String> choices = getValidInput(input);

        // Process input
        for (String choice : choices) {
            try {
                int index = Integer.parseInt(choice) - 1; // convert to 0-based
                if (index >= 0 && index < currentToppings.size()) {
                    Topping topping = currentToppings.get(index);
                    pizza.removeTopping(topping);
                    System.out.println("✅ Removed: " + topping.getLabel());
                } else if (index == -1) {
                    System.out.println("🚫 Skipped " + category.name());
                } else {
                    System.out.println("❌ Invalid choice: " + choice);
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input: " + choice);
            }
        }


        System.out.println("Available toppings: ");
        displayToppingMenu(available, category);

        System.out.println("Would you like to add more toppings?");
        // Get user input
        String addInput = getUserInput("Enter your choice(s) (e.g., 1 2 4): ");
        List<String> addedToppingCodes = getValidInput(addInput);

        if (addedToppingCodes.isEmpty()) {
            System.out.println("❌ No valid selection.");
            return;
        }

        // Process input
        for (String code : addedToppingCodes) {
            try {
                int index = Integer.parseInt(code) - 1; // convert to 0-based
                if (index >= 0 && index < available.size()) {
                    Topping topping = available.get(index);
                    pizza.addTopping(topping);
                    System.out.println("✅ Added: " + topping.getLabel());
                } else if (index == -1) {
                    System.out.println("🚫 Skipped " + category.name());
                } else {
                    System.out.println("❌ Invalid choice: " + code);
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input: " + code);
            }
        }
    }

    public void displayLogo() {
        String welcome = """
                 __       __)                            \s
                (, )  |  /     /)                        \s
                   | /| /  _  // _  ______    _    _/_ ___
                   |/ |/ _(/_(/_(__(_) // (__(/_   (__(_)\s
                   /  |                                  \s
                """;
        String logo = """
                █████▄ ▄▄ ▄▄▄▄▄ ▄▄▄▄▄ ▄████▄ ▄▄   ▄▄  ▄▄▄  ▄▄▄▄  ▄▄▄▄▄\s
                ██▄▄█▀ ██   ▄█▀   ▄█▀ ██▄▄██ ██▀▄▀██ ██▀██ ██▄█▄ ██▄▄ \s
                ██     ██ ▄██▄▄ ▄██▄▄ ██  ██ ██   ██ ▀███▀ ██ ██ ██▄▄▄\s
                                                                      \s
                                                                      \s
                                                                      \s
                """;

        int colorIndex = 0;
        System.out.println(welcome);

        try {
            for (char ch : logo.toCharArray()) {
                System.out.print(RAINBOW_COLORS[colorIndex % RAINBOW_COLORS.length] + ch);
                Thread.sleep(1);
                colorIndex++;
            }
            System.out.println(AnsiColors.RESET);
        } catch (InterruptedException e) {
            System.err.println("Error during logo animation:" + e.getMessage());
        }
    }



}
