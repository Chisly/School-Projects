/*
Ruben Bautista
CS 55 (Java)
Project 5 (Shopping)
May 13, 2021
 */
package shoppingcartprinter;

import java.util.Scanner;

public class ShoppingCartManager {

    private static Scanner scan = new Scanner(System.in);
    private static ShoppingCart cart;

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        info();
        printMenu();
    }

    public static void info() {
        System.out.println("Enter Customer's Name:");
        String name = scan.nextLine();
        System.out.println("Enter Today's Date:");
        String date = scan.nextLine();
        cart = new ShoppingCart(name, date);
        System.out.println("\nCustomer Name: " + name);
        System.out.println("Today's Date: " + date);
    }

    public static void printMenu() {
        System.out.println("\nMenu\n" + "a - Add item to cart\n" + "d - Remove item from cart\n" + "c - Change item quantity\n" + "i - Output items' descriptions\n" + "o - Output shopping cart\n" + "q - Quit\n");
        System.out.println("Choose an option:");
        char choice = scan.next().charAt(0);
        scan.nextLine();
        while (choice != 'q') {
            if (choice != 'a' && choice != 'd' && choice != 'c' && choice != 'i' && choice != 'o') {
                System.out.println("Choose an option:");
                choice = scan.next().charAt(0);
            } else {
                switch (choice) {
                    case 'a': {
                        System.out.println("\nADD ITEM TO CART");
                        System.out.println("Enter Item name:");
                        String name = scan.nextLine();
                        System.out.println("Enter Item description:");
                        String description = scan.nextLine();
                        System.out.println("Enter Item price:");
                        int price = scan.nextInt();
                        scan.nextLine();
                        System.out.println("Enter Item quantity:");
                        int quantity = scan.nextInt();
                        scan.nextLine();
                        ItemToPurchase item = new ItemToPurchase(name, description, price, quantity);
                        cart.addItem(item);
                        break;
                    }
                    case 'd': {
                        System.out.println("\nREMOVE ITEM FROM CART");
                        System.out.println("Name of item to remove:");
                        String itemToRemove = scan.nextLine();
                        cart.removeItem(itemToRemove);
                        break;
                    }
                    case 'c': {
                        System.out.println("\nCHANGE ITEM QUANTITY");
                        System.out.println("Enter item name:");
                        String name = scan.nextLine();
                        System.out.println("Enter the new quantity:");
                        int quantity = scan.nextInt();
                        scan.nextLine();
                        ItemToPurchase modItem = new ItemToPurchase(name, "none", 0, quantity);
                        cart.modifyItem(modItem);
                        break;
                    }
                    case 'i': {
                        System.out.println("\nOUTPUT ITEMS' DESCRIPTIONS");
                        cart.printDescriptions();
                        break;
                    }
                    case 'o': {
                        System.out.println("\nOUTPUT SHOPPING CART");
                        cart.printTotal();
                        break;
                    }
                }
                printMenu();
            }
        }
    }
}
