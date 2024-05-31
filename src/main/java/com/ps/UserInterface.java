package com.ps;

import java.util.Scanner;

public class UserInterface {
    public void display() {
        Scanner scanner = new Scanner(System.in);
        int command;

        do {
            displayMenu();
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();//consume non-int
            }
            command = scanner.nextInt();
            scanner.nextLine();//consume newline

            switch (command) {
                case 1:
                    newOrderMenu(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Command not found.");
            }
        } while (command != 0);

    }

    private void displayMenu() {
        System.out.println("------ Welcome to DELIcious Sandwiches ------");
        System.out.println("1. Start New Order");
        System.out.println("0. Quit");
        System.out.print("Enter your choice: ");
    }

    private void displayOrderMenu() {
        System.out.println("Order Menu");
        System.out.println("\t1) Add Sandwich");
        System.out.println("\t2) Add Drink");
        System.out.println("\t3) Add Chips");
        System.out.println("\t4) Checkout");
        System.out.println("\t0) Cancel Order");
        System.out.println("Enter your choice: ");
    }

    private void newOrderMenu(Scanner scanner) {
        Order order = new Order();
        int newOrderCommand;

        do {
            displayOrderMenu();
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();//consume non-int
            }
            newOrderCommand = scanner.nextInt();
            scanner.nextLine();//consume newline

            switch (newOrderCommand) {
                case 1:
                    addSandwich(scanner, order);
                    break;
                case 2:
                    addDrink(scanner, order);
                    break;
                case 3:
                    addChips(scanner, order);
                    break;
                case 4:
                    checkout(order);
                    return;
                case 0:
                    System.out.println("Order cancelled.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }

        } while (newOrderCommand != 0);
    }

    private void addSandwich(Scanner scanner, Order order) {
        System.out.println("Choose a Sandwich:");
        System.out.println("1. Custom Sandwich");
        System.out.println("2. BLT Signature Sandwich");
        System.out.println("3. Philly Cheese Steak Signature Sandwich");
        System.out.println("4. Steak and Mushroom Signature Sandwich");
        System.out.print("Enter your choice: ");
        int sandwichChoice = scanner.nextInt();
        scanner.nextLine();//consume newline

        switch (sandwichChoice) {
            case 1:
                addCustomSandwich(scanner, order);
                break;
            case 2:
                order.addProduct(new BLTSandwich());
                System.out.println("BLT Signature Sandwich added to order.");
                break;
            case 3:
                order.addProduct(new PhillyCheeseSteakSandwich());
                System.out.println("Philly Cheese Steak Signature Sandwich added to order.");
                break;
            case 4:
                order.addProduct(new SteakAndMushroomSandwich());
                System.out.println("Steak and Mushroom Signature Sandwich added to order.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    private void addCustomSandwich(Scanner scanner, Order order) {
        System.out.print("Enter sandwich size (4, 8, 12): ");
        int size = scanner.nextInt();
        scanner.nextLine();//consume newline

        System.out.print("Enter bread type (white, wheat, rye, wrap): ");
        String breadType = scanner.nextLine();

        System.out.print("Do you want it toasted? (yes/no): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("yes");
        Sandwich sandwich = new Sandwich(size, breadType, toasted);

        //Add meat
        System.out.println("Meat:\nSteak\nHam\nSalami\nRoast Beef\nChicken\nBacon");
        System.out.print("Enter meat type: ");
        String meatType = scanner.nextLine();
        double meatCost = getMeatCost(size);
        sandwich.addTopping(new Topping(meatType, true, meatCost));

        System.out.print("Do you want an extra serving of meat? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            double extraMeatCost = getExtraMeatCost(size);
            sandwich.addTopping(new Topping(meatType + " (Extra)", true, extraMeatCost));
        }
        //Add cheese
        System.out.println("Cheese:\nAmerican\nProvolone\nCheddar\nSwiss");
        System.out.print("Enter cheese type: ");
        String cheeseType = scanner.nextLine();
        double cheeseCost = getCheeseCost(size);
        sandwich.addTopping(new Topping(cheeseType, true, cheeseCost));

        System.out.print("Do you want an extra serving of cheese? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            double extraCheeseCost = getExtraCheeseCost(size);
            sandwich.addTopping(new Topping(cheeseType + " (Extra)", true, extraCheeseCost));
        }

        //Add toppings
        String addMore;
        do {
            System.out.println("Toppings:" + "\n" + "Lettuce, " + "Peppers, " + "Onions," + "\n" + "Tomatoes, " + "Jalapenos, " + "Cucumbers," + "\n" + "Pickles, " + "Guacamole, " + "Mushrooms");
            System.out.print("Enter topping name (or 'done' to finish): ");
            String toppingName = scanner.nextLine();
            if (toppingName.equalsIgnoreCase("done")) {
                break;
            }


            System.out.print("Add another topping? (yes/no): ");
            addMore = scanner.nextLine();
        } while (addMore.equalsIgnoreCase("yes"));

        //Add sauce
        String addMore2;
        do {
            System.out.println("Sauces:" + "\n" + "Mayo, " + "Mustard, " + "Ketchup," + "\n" + "Ranch, " + "Thousand Island, " + "Vinaigrette," + "\n" + "Au Jus(side)");
            System.out.print("Enter sauce name (or 'done' to finish): ");
            String toppingName = scanner.nextLine();
            if (toppingName.equalsIgnoreCase("done")) {
                break;
            }


            System.out.print("Add another sauce? (yes/no): ");
            addMore2 = scanner.nextLine();
        } while (addMore2.equalsIgnoreCase("yes"));


        order.addProduct(sandwich);
        System.out.println("Sandwich added to order.");
    }

    private double getMeatCost(int size) {
        switch (size) {
            case 4:
                return 1.00;
            case 8:
                return 2.00;
            case 12:
                return 3.00;
            default:
                return 0.00;
        }
    }

    private double getExtraMeatCost(int size) {
        switch (size) {
            case 4:
                return 0.50;
            case 8:
                return 1.00;
            case 12:
                return 1.50;
            default:
                return 0.00;
        }
    }

    private double getCheeseCost(int size) {
        switch (size) {
            case 4:
                return 0.75;
            case 8:
                return 1.50;
            case 12:
                return 2.25;
            default:
                return 0.00;
        }
    }

    private double getExtraCheeseCost(int size) {
        switch (size) {
            case 4:
                return 0.30;
            case 8:
                return 0.60;
            case 12:
                return 0.90;
            default:
                return 0.00;
        }
    }

    private void addDrink(Scanner scanner, Order order) {
        System.out.print("Enter drink name: ");
        String drinkName = scanner.nextLine();

        System.out.print("Enter drink size (small, medium, large): ");
        String size = scanner.nextLine();

        Drink drink = new Drink(drinkName, size);
        order.addProduct(drink);
        System.out.println("Drink added to order.");
    }

    private void addChips(Scanner scanner, Order order) {
        System.out.print("Enter chip name: ");
        String chipName = scanner.nextLine();
        double chipPrice = 1.50;

        Chips chip = new Chips(chipPrice, chipName);
        order.addProduct(chip);
        System.out.println("Chips added to order.");
    }

    private void checkout(Order order) {
        order.displayOrderDetails();
        order.saveReceipt();
        System.out.println("Order completed and receipt saved.");
    }

}





