/*
Ruben Bautista
CS 55 (Java)
Project 6 (Inheritance)
May 24, 2021
 */
package polymorphic;

import java.util.ArrayList;

public abstract class Coffee implements HowToMakeDrink
{
    public String coffeeType;
    public double price;
    public String storeName;
    public String ingredient;
    public ArrayList<String> in = new ArrayList<>();
    public ArrayList<Coffee> types = new ArrayList<>();
    
    public abstract void ingredient();
}
