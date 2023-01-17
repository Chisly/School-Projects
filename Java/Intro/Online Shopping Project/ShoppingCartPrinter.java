/*
Ruben Bautista
CS 55 (Java)
Project 5 (Shopping)
May 13, 2021
 */
package shoppingcartprinter;

import java.util.Scanner;

public class ShoppingCartPrinter 
{
    private static Scanner scan = new Scanner(System.in);
    private static ItemToPurchase item1 = new ItemToPurchase();
    private static ItemToPurchase item2 = new ItemToPurchase();
    
    public static void main(String[] args)
    {
        int total = 0;
        int itemTotal = 0;
        int itemTotal2 = 0;

        item1();
        item2();
        
        itemTotal = (item1.getQuantity() * item1.getPrice());
        itemTotal2 = (item2.getQuantity() * item2.getPrice());
        total = (itemTotal + itemTotal2);
        System.out.println("\nTotal Cost");
        System.out.println(item1.getName() + " "+ item1.getQuantity() + " @ $" + item1.getPrice() + " = $" + itemTotal);
        System.out.println(item2.getName() + " "+ item2.getQuantity() + " @ $" + item2.getPrice() + " = $" + itemTotal2);
        System.out.println("\nTotal: $" + total);
    }
    
    public static void item1()
    {
        System.out.println("Item 1");
        System.out.println("Enter the Item Name:");
        item1.setName(scan.nextLine());
        System.out.println("Enter the Item Price:");
        item1.setPrice(scan.nextInt());
        System.out.println("Enter the Item Quantity:");
        item1.setQuantity(scan.nextInt());
        scan.nextLine();
    }
    public static void item2()
    {
        System.out.println("Item 2");
        System.out.println("Enter the Item Name:");
        item2.setName(scan.nextLine());
        System.out.println("Enter the Item Price:");
        item2.setPrice(scan.nextInt());
        System.out.println("Enter the Item Quantity:");
        item2.setQuantity(scan.nextInt());
    }
}
