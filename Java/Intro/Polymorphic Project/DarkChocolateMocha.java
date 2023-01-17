/*
Ruben Bautista
CS 55 (Java)
Project 6 (Inheritance)
May 24, 2021
 */
package polymorphic;

public class DarkChocolateMocha extends Coffee
{
    public DarkChocolateMocha()
    {}
    
    public DarkChocolateMocha(String sName)
    {
        this.coffeeType = "Dark Chocolate Mocha";
        this.storeName = sName;
        this.price = 3.5;
    }
    
    @Override
    public void ingredient()
    {
        in.add("Dark Chocolate");
        in.add("Brewed Espresso");
        in.add("Whipped Cream");
        in.add("Mocha Sauce");
        in.add("Milk");
    }
    
    @Override
    public void prepare()
    {
        ingredient();
        System.out.println(in);
    }
}
