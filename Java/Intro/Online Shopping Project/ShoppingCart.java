/*
Ruben Bautista
CS 55 (Java)
Project 5 (Shopping)
May 13, 2021
 */
package shoppingcartprinter;

import java.util.ArrayList;

public class ShoppingCart 
{
    private ArrayList<ItemToPurchase> cartItems;
    private String customerName;
    private String currentDate;
    
    public ShoppingCart()
    {
        customerName = "none";
        currentDate = "January 1, 2016";
        cartItems = new ArrayList<>();
    }
    public ShoppingCart(String name, String date)
    {
        this.customerName = name;
        this.currentDate = date;
        cartItems = new ArrayList<>();
    }
    
    public String getCustomerName()
    {
        return customerName;
    }
    public String getDate()
    {
        return currentDate;
    }
    public void addItem(ItemToPurchase item)
    {
        cartItems.add(item);
    }
    public void removeItem(String itemToRemove)
    {
        for (ItemToPurchase item : cartItems) {
            if (item.getName().equals(itemToRemove)) {
                cartItems.remove(item);
                return;
            }
            System.out.println("\nItem not found in cart. Nothing removed."); 
        }
    }
    public void modifyItem(ItemToPurchase modItem)
    {
        boolean exists = false;
        for (ItemToPurchase item : cartItems) {
            if (item.getName().equals(modItem.getName())) {
                exists = true;
                if (!modItem.getDescription().equals("none")) {
                    item.setDescription(modItem.getDescription());
                }
                if (modItem.getQuantity() != 0) {
                    item.setQuantity(modItem.getQuantity());
                }
                if (modItem.getPrice() != 0) {
                    item.setPrice(modItem.getPrice());
                }
            }
        }
        if(exists == false)
            System.out.println("\nItem not found in cart. Nothing modified."); 
    }
    public int getNumItemsInCart()
    {
        int total = 0;
        for (ItemToPurchase item : cartItems) {
            total += item.getQuantity();
        }
       return total;
    }
    public int getCostOfCart()
    {
        int cartTotal = 0;
        for (ItemToPurchase item : cartItems) {
            cartTotal += (item.getQuantity() * item.getPrice());
        }
        return cartTotal;
    }
    public void printTotal()
    {
        if (cartItems == null || cartItems.size() == 0) {
            System.out.println("\nSHOPPING CART IS EMPTY.");
            return;
        }
        System.out.println(customerName + "'s Shopping Cart - " + currentDate);
        System.out.println("\nNumber of Items: " + getNumItemsInCart());
        for (ItemToPurchase item : cartItems) {
            item.printItemCost();
        }
        System.out.println("Total: $" + getCostOfCart());
    }
    public void printDescriptions()
    {
        if (cartItems == null || cartItems.size() == 0) {
            System.out.println("\nSHOPPING CART IS EMPTY.");
            return;
        }
        System.out.println(customerName + "'s Shopping Cart - " + currentDate);
        System.out.println("\nItem Descriptions");
       for (ItemToPurchase item : cartItems) {
           item.printItemDescription();
       }
    }
}
