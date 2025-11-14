package com.miaraylight.pizzamore.ui;

import com.miaraylight.pizzamore.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.miaraylight.pizzamore.ui.AnsiColors.*;

public class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);
    private Order order;

    public void initOrder() {
        this.order = new Order();
    }

    public void display() {
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
                    System.out.println("create a function with spinning logo as a loader");
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
            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "S":
                    System.out.println("Signature Pizza selected.");
                    Pizza signature = getSignaturePizza();
                    System.out.println(getSignaturePizza());
                    System.out.println("Would you like to customize it? (y/n)");
                    String customize = scanner.nextLine().trim().toUpperCase();
                    if (customize.equalsIgnoreCase("y")) {
//                        Pizza customizedSignature = runCustomizeMenu(signature);
//                        order.addToOrder(customizedSignature);
                    }
                    order.addToOrder(signature);
                    System.out.println("order");
                    System.out.println(order);
                    break;
                case "V":
                    System.out.println("Veggie Pizza selected.");
                    order.addToOrder(getVeggiePizza());
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
            displayCustomizePizzaMenu();
            System.out.print("What would you like to customize? ");
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
                    displayPremiumToppingMenu();
                    System.out.println("You can choose single or multiple option");
                    String premium = getUserInput("Choose protein (1–6)");
                    String premiumTopping = "";

                    if (premium.length() > 1) {
                        List<String> choices = getValidInput(premium);
                        System.out.println(choices);

                        for (String choice : choices) {
                            String label = "";
                            switch (choice) {
                                case "1": label = "Pepperoni"; break;
                                case "2": label = "Sausage"; break;
                                case "3": label = "Ham"; break;
                                case "4": label = "Bacon"; break;
                                case "5": label = "Chicken"; break;
                                case "6": label = "Meatball"; break;
                                case "0": break;
                                default:
                                    System.out.println("❌ Invalid protein option.");
                                    continue;
                            }
                            myStylePizza.addTopping(Topping.fromInput(label));
                        }
                    } else {
                        switch (premium) {
                            case "1": premiumTopping = "Pepperoni"; break;
                            case "2": premiumTopping = "Sausage"; break;
                            case "3": premiumTopping = "Ham"; break;
                            case "4": premiumTopping = "Bacon"; break;
                            case "5": premiumTopping = "Chicken"; break;
                            case "6": premiumTopping = "Meatball"; break;
                            case "0": premiumTopping = ""; break;
                            default:
                                System.out.println("❌ Invalid protein option.");
                                continue;
                        }

                        myStylePizza.addTopping(Topping.fromInput(premiumTopping));
                        System.out.println("✅ Added premium topping: " + premiumTopping);
                    }




                    break;

                // 🥦 REGULAR TOPPINGS
                case 5:
                    displayRegularToppingMenu();
                    System.out.println("You can choose single or multiple option");
                    String regular = getUserInput("Choose topping (1–9):");
                    //implement logic handling multiple input
                    String regularTopping = "";

                    if (regular.length() > 1) {
                        List<String> choices = getValidInput(regular);

                        for (String choice : choices) {
                            String label = "";

                            switch (regular) {
                                case "1": label = "Onions"; break;
                                case "2": label = "Mushrooms"; break;
                                case "3": label = "Bell Peppers"; break;
                                case "4": label = "Olives"; break;
                                case "5": label = "Tomatoes"; break;
                                case "6": label = "Spinach"; break;
                                case "7": label = "Basil"; break;
                                case "8": label = "Pineapple"; break;
                                case "9": label = "Anchovies"; break;
                                case "0": label = ""; break;
                                default:
                                    System.out.println("❌ Invalid topping option.");
                                    continue;
                            }

                            myStylePizza.addTopping(Topping.fromInput(label));
                        }
                    } else {
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
                            case "0": regularTopping = ""; break;
                            default:
                                System.out.println("❌ Invalid topping option.");
                                continue;
                        }

                        myStylePizza.addTopping(Topping.fromInput(regularTopping));

                        System.out.println(myStylePizza );
                    }


                    break;

                // 🧀 CHEESE
                case 6:
                    displayCheeseToppingMenu();
                    System.out.println("You can choose single or multiple option");
                    String cheeseInput = getUserInput("Choose cheese (1–5):");
                    String cheese = "";

                    if (cheeseInput.length() > 1) {
                        List<String> choices = getValidInput(cheeseInput);
                        String label = "";

                        for (String choice : choices) {
                            switch (cheeseInput) {
                                case "1": label = "Mozzarella"; break;
                                case "2": label = "Parmesan"; break;
                                case "3": label = "Ricotta"; break;
                                case "4": label = "Goat Cheese"; break;
                                case "5": label = "Buffalo"; break;
                                default:
                                    System.out.println("❌ Invalid cheese option.");
                                    continue;
                            }
                        }

                        myStylePizza.addTopping(Topping.fromInput(label));
                    } else {
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

                        myStylePizza.addTopping(Topping.fromInput(cheese));
                        System.out.println("✅ Added cheese: " + cheese + order);
                    }


                    break;

                // 🍽 SIDES
                case 7:
                    displaySidesMenu();
                    String sideInput = getUserInput("Choose side (1–2):");
                    String side = "";

                    switch (sideInput) {
                        case "1": side = "Red Pepper"; break;
                        case "2": side = "Parmesan"; break;
                        case "0": side = ""; break;
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
                    System.out.println("Added!" + order);
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

//    private Pizza runCustomizeMenu(Pizza pizza) {
//        boolean running = true;
//
//        while (running) {
//            displayCustomizePizzaMenu();
//            System.out.print("What would you like to customize? ");
//            int input = scanner.nextInt();
//            scanner.nextLine();
//
//
//            switch (input) {
//
//                // 🍕 PIZZA SIZE
//                case 1:
//                    pizza.setSize(askForSize(UserInterface::displayPizzaSizeMenu));
//                    break;
//
//                // 🫓 CRUST
//                case 2:
//                    displayPizzaCrustMenu();
//                    System.out.println("Original crust type is " + pizza.getCrustType());
//                    String crust = getUserInput("Choose crust type:");
//
//                    switch (crust) {
//                        case "1": pizza.setCrustType(CrustType.THIN); break;
//                        case "2": pizza.setCrustType(CrustType.REGULAR); break;
//                        case "3": pizza.setCrustType(CrustType.THICK); break;
//                        case "4": pizza.setCrustType(CrustType.CAULIFLOWER); break;
//                        default:
//                            System.out.println("❌ Invalid crust option.");
//                            continue;
//                    }
//                    System.out.println("✅ Selected crust: " + pizza.getCrustType());
//                    break;
//
//                // 🍅 SAUCE
//                case 3:
//                    displayPizzaSauceMenu();
//                    System.out.println("Original sauce type is " + pizza.getSauceType());
//                    String sauce = getUserInput("Choose sauce:");
//
//                    switch (sauce) {
//                        case "1": pizza.setSauceType(SauceType.MARINARA); break;
//                        case "2": pizza.setSauceType(SauceType.ALFREDO); break;
//                        case "3": pizza.setSauceType(SauceType.PESTO); break;
//                        case "4": pizza.setSauceType(SauceType.BBQ); break;
//                        case "5": pizza.setSauceType(SauceType.BUFFALO); break;
//                        case "6": pizza.setSauceType(SauceType.OLIVE_OIL); break;
//                        default:
//                            System.out.println("❌ Invalid sauce option.");
//                            continue;
//                    }
//                    System.out.println("✅ Selected sauce: " + pizza.getSauceType());
//                    break;
//
//                // 🍖 PREMIUM TOPPINGS
//                case 4:
//                    displayPremiumToppingMenu();
//                    //System.out.println("Original protein toppings" + pizza.getToppings(ToppingType.Premium));
//                    System.out.println("✅ Added premium topping: ");
//                    break;
//
//                // 🥦 REGULAR TOPPINGS
//                case 5:
//                    displayRegularToppingMenu();
//                    System.out.println("You can choose single or multiple option");
//                    String regular = getUserInput("Choose topping (1–9):");
//                    //implement logic handling multiple input
//                    String regularTopping = "";
//
//                    switch (regular) {
//                        case "1": regularTopping = "Onions"; break;
//                        case "2": regularTopping = "Mushrooms"; break;
//                        case "3": regularTopping = "Bell Peppers"; break;
//                        case "4": regularTopping = "Olives"; break;
//                        case "5": regularTopping = "Tomatoes"; break;
//                        case "6": regularTopping = "Spinach"; break;
//                        case "7": regularTopping = "Basil"; break;
//                        case "8": regularTopping = "Pineapple"; break;
//                        case "9": regularTopping = "Anchovies"; break;
//                        case "0": regularTopping = ""; break;
//                        default:
//                            System.out.println("❌ Invalid topping option.");
//                            continue;
//                    }
//                    System.out.println(regularTopping.isEmpty() ? "No toppings" : "✅ Added regular topping: " + regularTopping );
//                    break;
//
//                // 🧀 CHEESE
//                case 6:
//                    displayCheeseToppingMenu();
//                    System.out.println("You can choose single or multiple option");
//                    String cheeseInput = getUserInput("Choose cheese (1–5):");
//                    String cheese = "";
//
//                    switch (cheeseInput) {
//                        case "1": cheese = "Mozzarella"; break;
//                        case "2": cheese = "Parmesan"; break;
//                        case "3": cheese = "Ricotta"; break;
//                        case "4": cheese = "Goat Cheese"; break;
//                        case "5": cheese = "Buffalo"; break;
//                        default:
//                            System.out.println("❌ Invalid cheese option.");
//                            continue;
//                    }
//                    System.out.println("✅ Added cheese: " + cheese);
//                    break;
//
//                // 🍽 SIDES
//                case 7:
//                    displaySidesMenu();
//                    String sideInput = getUserInput("Choose side (1–2):");
//                    String side = "";
//
//                    switch (sideInput) {
//                        case "1": side = "Red Pepper"; break;
//                        case "2": side = "Parmesan"; break;
//                        case "0": side = ""; break;
//                        default:
//                            System.out.println("❌ Invalid side option.");
//                            continue;
//                    }
//                    System.out.println("✅ Added side: " + side);
//                    break;
//                case 8:
//                    //save pizza
//                    System.out.println("Adding to your order...");
//                    System.out.println("Added!");
//                    running = false;
//                // 🔙 EXIT
//                case 0:
//                    System.out.println("Returning to main menu...");
//                    running = false;
//                    break;
//
//                default:
//                    System.out.println("❌ Invalid choice. Please try again.");
//            }
//        }
//
//        return pizza;
//    }

    public void runDrinksMenu() {
        boolean running = true;

        while (running) {
            displayDrinksMenu();
            String choice = getUserInput("Choose a drink: ");

            if("0".equals(choice)) {
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

            if(drink != null) {
                System.out.println("✅ Added " + drink.getSize() + " " + drink.getName() + " — Price: $" + drink.getPrice());
                order.addToOrder(drink);
            }

            String more = getUserInput("Do you want to add another drink? (y/n): ");
            if (!more.equalsIgnoreCase("y")) {
                running = false; // exit loop and return to main menu
            }
        }
        System.out.println("🛒 Returning to main menu with your drinks added.");
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

            String more = getUserInput("Do you want to add another bread? (y/n):");
            if (!more.equalsIgnoreCase("y")) running = false;

        }

        System.out.println("🛒 Returning to main menu with your breads added.");
    }

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
        System.out.println("  " + MAGENTA + "[X]" + RESET + " 🔙 Go Back");
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

    public static void displayCustomizePizzaMenu() {
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
        System.out.println("  " + GREEN + "[0]" + RESET + " 🚫 No protein");
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
        System.out.println("  " + GREEN + "[0]" + RESET + " 🚫 No toppings");
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

    public static void displayReceipt() {
        System.out.println("Receipt with menu items and total");
    }

    // helpers
    public static String getUserInput(String prompt) {
        System.out.print(prompt + " ");
        return scanner.nextLine().trim().toUpperCase();
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



    private List<String>  getValidInput (String input) {
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
}
