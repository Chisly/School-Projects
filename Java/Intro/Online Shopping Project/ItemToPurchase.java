/*
Ruben Bautista
CS 55 (Java)
Project 5 (Shopping)
May 13, 2021
 */
package shoppingcartprinter;


public class ItemToPurchase 
{
    private String itemName;
    private int itemPrice;
    private int itemQuantity;
    private String itemDescription;
    
    public ItemToPurchase()
    {
        this.itemName = "none";
        this.itemPrice = 0;
        this.itemQuantity = 0;
        this.itemDescription = "none";
    }
    public ItemToPurchase(String name, String description, int price, int quantity)
    {
        this.itemName = name;
        this.itemDescription = description;
        this.itemPrice = price;
        this.itemQuantity = quantity;
    }
    public void setName(String name)
    {
        this.itemName = name;
    }
    public String getName()
    {
        return itemName;
    }
    public void setPrice(int price)
    {
        this.itemPrice = price;
    }
    public int getPrice()
    {
        return itemPrice;
    }
    public void setQuantity(int amount)
    {
        this.itemQuantity = amount;
    }
    public int getQuantity()
    {
        return itemQuantity;
    }
    public void setDescription(String description)
    {
        this.itemDescription = description;
    }
    public String getDescription()
    {
        return itemDescription;
    }
    public void printItemCost()
    {
        int itemTotal = (getQuantity() * getPrice());
        
        System.out.println(getName() + " " + getQuantity() + " @ $" + getPrice() + " = " + itemTotal);
    }
    public void printItemDescription()
    {
        System.out.println(getName() + ": " + getDescription());
    }
}
