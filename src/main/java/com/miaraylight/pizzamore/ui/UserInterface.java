package com.miaraylight.pizzamore.ui;

import java.util.Scanner;

import static com.miaraylight.pizzamore.ui.AnsiColors.*;

public class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);

    public void display() {
        int input;
        do {
            displayMainMenu();
            // Logo animation and other
            System.out.println("Enter your choice:");
            while (!scanner.hasNextInt()) {
                System.out.println("Enter a number please:");
                scanner.next();
            }

            input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    System.out.println("create a function with spinning logo as a loader");

                    runOrderMenu();
                    break;
                case 0:
                    System.out.println("Order cancelled");
                    break;
                default:
                    System.out.println("Invalid input. Try again");
            }
        }while (input != 0);


    };

    public void runOrderMenu() {
        boolean running = true;
        String choice = scanner.nextLine().trim().toUpperCase();
        while (running) {
            displayOrderMenu();
            System.out.println("What to get...");

            switch (choice) {
                case "P":
                    runCustomizeMenu();
                    break;
                case "D":
                    //displayDrinkMenu()
                    break;
                case "B":
                    //displayBreadMenu()
                    break;
                default:
                    System.out.println("Invalid choice. Try again");
            }
        }
    }

    public void runPizzaMenu() {
        boolean running = true;
        String choice = scanner.nextLine().trim().toUpperCase();
        while (running) {
            displayPizzaMenu();
            System.out.println("What to get...");

            switch (choice) {
                case "S":
                    System.out.println("S");
                    // pre-made Pizza signature = new Pizza()
                    // add to Order
                    // display receipt(Order)
                    // System.out.println("Proceed | Customize | Add more"); // probably will need to do pretty buttons
                    // String input = scanner.nextLine().trim().toUpperCase();
                    break;
                case "V":
                    // pre-made Pizza veggie = new Pizza()
                    // add to Order
                    // display receipt(Order)
                    // System.out.println("Proceed | Customize | Add more"); // probably will need to do pretty buttons
                    // String input = scanner.nextLine().trim().toUpperCase();
                    break;
                case "B":
                    System.out.println("Lets build it!");
                    runCustomizeMenu();
                    break;
                case "X":
                    System.out.println("Going back");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again");
            }
        }
    }

    private void runCustomizeMenu() {
        boolean running = true;

        while (running) {
            displayCustomizePizzaMenu();
            System.out.print("What would you like to customize? ");
            int input = scanner.nextInt();
            scanner.nextLine(); // clear input buffer

            switch (input) {

                // 🍕 PIZZA SIZE
                case 1:
                    displayPizzaSizeMenu();
                    String size = getUserInput("Choose size (S/M/L):");
                    int pizzaSize = 0;

                    switch (size) {
                        case "S": pizzaSize = 8; break;
                        case "M": pizzaSize = 12; break;
                        case "L": pizzaSize = 16; break;
                        default:
                            System.out.println("❌ Invalid size option.");
                            continue;
                    }
                    System.out.println("✅ Selected size: " + pizzaSize + " inch");
                    break;

                // 🫓 CRUST
                case 2:
                    displayPizzaCrustMenu();
                    String crust = getUserInput("Choose crust (A/S/D/F):");
                    String crustType = "";

                    switch (crust) {
                        case "A": crustType = "Thin"; break;
                        case "S": crustType = "Regular"; break;
                        case "D": crustType = "Thick"; break;
                        case "F": crustType = "Cauliflower"; break;
                        default:
                            System.out.println("❌ Invalid crust option.");
                            continue;
                    }
                    System.out.println("✅ Selected crust: " + crustType);
                    break;

                // 🍅 SAUCE
                case 3:
                    displayPizzaSauceMenu();
                    String sauce = getUserInput("Choose sauce (A/S/D/J/K/L):");
                    String sauceType = "";

                    switch (sauce) {
                        case "A": sauceType = "Marinara"; break;
                        case "S": sauceType = "Alfredo"; break;
                        case "D": sauceType = "Pesto"; break;
                        case "J": sauceType = "BBQ"; break;
                        case "K": sauceType = "Buffalo"; break;
                        case "L": sauceType = "Olive Oil"; break;
                        default:
                            System.out.println("❌ Invalid sauce option.");
                            continue;
                    }
                    System.out.println("✅ Selected sauce: " + sauceType);
                    break;

                // 🍖 PREMIUM TOPPINGS
                case 4:
                    displayPremiumToppingMenu();
                    String premium = getUserInput("Choose protein (1–6):");
                    String premiumTopping = "";

                    switch (premium) {
                        case "1": premiumTopping = "Pepperoni"; break;
                        case "2": premiumTopping = "Sausage"; break;
                        case "3": premiumTopping = "Ham"; break;
                        case "4": premiumTopping = "Bacon"; break;
                        case "5": premiumTopping = "Chicken"; break;
                        case "6": premiumTopping = "Meatball"; break;
                        default:
                            System.out.println("❌ Invalid protein option.");
                            continue;
                    }
                    System.out.println("✅ Added premium topping: " + premiumTopping);
                    break;

                // 🥦 REGULAR TOPPINGS
                case 5:
                    displayRegularToppingMenu();
                    String regular = getUserInput("Choose topping (1–9):");
                    String regularTopping = "";

                    switch (regular) {
                        case "1": regularTopping = "Onions"; break;
                        case "2": regularTopping = "Mushrooms"; break;
                        case "3": regularTopping = "Bell Peppers"; break;
                        case "4": regularTopping = "Olives"; break;
                        case "5": regularTopping = "Tomatoes"; break;
                        case "6": regularTopping = "Spinach"; break;
                        case "7": regularTopping = "Basil"; break;
                        case "8": regularTopping = "Pineapple"; break;
                        case "9": regularTopping = "Anchovies"; break;
                        default:
                            System.out.println("❌ Invalid topping option.");
                            continue;
                    }
                    System.out.println("✅ Added regular topping: " + regularTopping);
                    break;

                // 🧀 CHEESE
                case 6:
                    displayCheeseToppingMenu();
                    String cheeseInput = getUserInput("Choose cheese (1–5):");
                    String cheese = "";

                    switch (cheeseInput) {
                        case "1": cheese = "Mozzarella"; break;
                        case "2": cheese = "Parmesan"; break;
                        case "3": cheese = "Ricotta"; break;
                        case "4": cheese = "Goat Cheese"; break;
                        case "5": cheese = "Buffalo"; break;
                        default:
                            System.out.println("❌ Invalid cheese option.");
                            continue;
                    }
                    System.out.println("✅ Added cheese: " + cheese);
                    break;

                // 🍽 SIDES
                case 7:
                    displaySidesMenu();
                    String sideInput = getUserInput("Choose side (1–2):");
                    String side = "";

                    switch (sideInput) {
                        case "1": side = "Red Pepper"; break;
                        case "2": side = "Parmesan"; break;
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
                    System.out.println("Returning to pizza menu...");
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
        System.out.println("  " + GREEN + "[1]" + RESET + " 🍕 Pizza");
        System.out.println("  " + GREEN + "[2]" + RESET + " 🥤 Drinks");
        System.out.println("  " + GREEN + "[3]" + RESET + " 🧄 Garlic Knots");
        System.out.println("  " + MAGENTA + "[0]" + RESET + " 🔙 Go Back");
        System.out.println(CYAN + "╚════════════════════════════════════════════╝" + RESET);
    }

    public static void displayPizzaMenu() {
        System.out.println(BOLD + CYAN + "╔════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "               Choose Your Pizza Type        " + RESET);
        System.out.println(CYAN + "╠════════════════════════════════════════════╣" + RESET);
        System.out.println("  " + GREEN + "[1]" + RESET + " ⭐ Signature Pizza");
        System.out.println("  " + GREEN + "[2]" + RESET + " 🥦 Veggie Pizza");
        System.out.println("  " + GREEN + "[3]" + RESET + " 🍳 Build My Own Pizza");
        System.out.println("  " + MAGENTA + "[0]" + RESET + " 🔙 Go Back");
        System.out.println(CYAN + "╚════════════════════════════════════════════╝" + RESET);
    }

    public static void displayCustomizePizzaMenu() {
        System.out.println(BOLD + CYAN + "╔════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "             Customize Your Pizza            " + RESET);
        System.out.println(CYAN + "╠════════════════════════════════════════════╣" + RESET);
        System.out.println("  " + GREEN + "[1]" + RESET + " 📏 Size");
        System.out.println("  " + GREEN + "[2]" + RESET + " 🍞 Crust Type");
        System.out.println("  " + GREEN + "[3]" + RESET + " 🍅 Sauce");
        System.out.println("  " + GREEN + "[4]" + RESET + " 🍖 Protein (Premium Toppings)");
        System.out.println("  " + GREEN + "[5]" + RESET + " 🥦 Regular Toppings");
        System.out.println("  " + GREEN + "[6]" + RESET + " 🧀 Cheese");
        System.out.println("  " + GREEN + "[7]" + RESET + " 🍽️ Sides");
        System.out.println("  " + MAGENTA + "[0]" + RESET + " ✅ Done / Go Back");
        System.out.println(CYAN + "╚════════════════════════════════════════════╝" + RESET);
    }

    public static void displayPizzaSizeMenu() {
        System.out.println(BOLD + CYAN + "╔════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "              Choose Your Pizza Size         " + RESET);
        System.out.println(CYAN + "╠════════════════════════════════════════════╣" + RESET);
        System.out.println("  " + GREEN + "[1]" + RESET + " 🍕 Small (8\")");
        System.out.println("  " + GREEN + "[2]" + RESET + " 🍕 Medium (12\")");
        System.out.println("  " + GREEN + "[3]" + RESET + " 🍕 Large (16\")");
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

    public static void displayPremiumToppingMenu() {
        System.out.println(BOLD + CYAN + "╔════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "               Choose Your Protein           " + RESET);
        System.out.println(CYAN + "╠════════════════════════════════════════════╣" + RESET);
        System.out.println("  " + GREEN + "[1]" + RESET + " 🍕 Pepperoni");
        System.out.println("  " + GREEN + "[2]" + RESET + " 🌭 Sausage");
        System.out.println("  " + GREEN + "[3]" + RESET + " 🍖 Ham");
        System.out.println("  " + GREEN + "[4]" + RESET + " 🥓 Bacon");
        System.out.println("  " + GREEN + "[5]" + RESET + " 🍗 Chicken");
        System.out.println("  " + GREEN + "[6]" + RESET + " 🧆 Meatball");
        System.out.println(CYAN + "╚════════════════════════════════════════════╝" + RESET);
    }

    public static void displayRegularToppingMenu() {
        System.out.println(BOLD + CYAN + "╔════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "            Choose Your Regular Toppings     " + RESET);
        System.out.println(CYAN + "╠════════════════════════════════════════════╣" + RESET);
        System.out.println("  " + GREEN + "[1]" + RESET + " 🧅 Onions");
        System.out.println("  " + GREEN + "[2]" + RESET + " 🍄 Mushrooms");
        System.out.println("  " + GREEN + "[3]" + RESET + " 🌶️ Bell Peppers");
        System.out.println("  " + GREEN + "[4]" + RESET + " 🫒 Olives");
        System.out.println("  " + GREEN + "[5]" + RESET + " 🍅 Tomatoes");
        System.out.println("  " + GREEN + "[6]" + RESET + " 🌿 Spinach");
        System.out.println("  " + GREEN + "[7]" + RESET + " 🌿 Basil");
        System.out.println("  " + GREEN + "[8]" + RESET + " 🍍 Pineapple");
        System.out.println("  " + GREEN + "[9]" + RESET + " 🐟 Anchovies");
        System.out.println(CYAN + "╚════════════════════════════════════════════╝" + RESET);
    }

    public static void displayCheeseToppingMenu() {
        System.out.println(BOLD + CYAN + "╔════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "                 Choose Your Cheese          " + RESET);
        System.out.println(CYAN + "╠════════════════════════════════════════════╣" + RESET);
        System.out.println("  " + GREEN + "[1]" + RESET + " 🧀 Mozzarella");
        System.out.println("  " + GREEN + "[2]" + RESET + " 🧂 Parmesan");
        System.out.println("  " + GREEN + "[3]" + RESET + " 🍶 Ricotta");
        System.out.println("  " + GREEN + "[4]" + RESET + " 🐐 Goat Cheese");
        System.out.println("  " + GREEN + "[5]" + RESET + " 🐃 Buffalo");
        System.out.println(CYAN + "╚════════════════════════════════════════════╝" + RESET);
    }

    public static void displayDrinksMenu() {
        System.out.println(BOLD + CYAN + "╔════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "                Choose Your Drinks           " + RESET);
        System.out.println(CYAN + "╠════════════════════════════════════════════╣" + RESET);
        System.out.println("  " + GREEN + "[1]" + RESET + " 🥤 Smoothie");
        System.out.println("  " + GREEN + "[2]" + RESET + " 🍊 Orange Juice");
        System.out.println("  " + GREEN + "[3]" + RESET + " 🚫 No Drink");
        System.out.println(CYAN + "╚════════════════════════════════════════════╝" + RESET);
    }

    public static void displaySidesMenu() {
        System.out.println(BOLD + CYAN + "╔════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "                 Choose Your Sides           " + RESET);
        System.out.println(CYAN + "╠════════════════════════════════════════════╣" + RESET);
        System.out.println("  " + GREEN + "[1]" + RESET + " 🌶️ Red Pepper");
        System.out.println("  " + GREEN + "[2]" + RESET + " 🧂 Parmesan");
        System.out.println("  " + GREEN + "[3]" + RESET + " 🚫 No Sides");
        System.out.println(CYAN + "╚════════════════════════════════════════════╝" + RESET);
    }

    public static void displayReceipt() {
        System.out.println("Receipt with menu items and total");
    }

    public static String getUserInput(String prompt) {
        System.out.print(prompt + " ");
        return scanner.nextLine().trim().toUpperCase();
    }
}
