/*
Ruben Bautista
CS 55 (Java)
Project 6 (Inheritance)
May 24, 2021
 */
package polymorphic;

public class CoffeeMocha extends Coffee
{
    public CoffeeMocha()
    {}
    
    public CoffeeMocha(String sName)
    {
        this.coffeeType = "Coffee Mocha";
        this.storeName = sName;
    }
    
    public void setIn(String inName)
    {
        this.ingredient = inName;
        ingredient();
    }
    
    @Override
    public void ingredient()
    {
        in.add(ingredient);
        this.price += 0.75;
    }
    
    @Override
    public void prepare()
    {
        this.price = (in.size()*0.75);
        System.out.println(in);
    }
}
