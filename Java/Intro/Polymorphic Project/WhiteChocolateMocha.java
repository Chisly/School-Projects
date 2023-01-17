/*
Ruben Bautista
CS 55 (Java)
Project 6 (Inheritance)
May 24, 2021
 */
package polymorphic;

public class WhiteChocolateMocha extends Coffee
{
    public WhiteChocolateMocha()
    {}
    
    public WhiteChocolateMocha(String sName)
    {
        this.coffeeType = "White Chocolate Mocha";
        this.storeName = sName;
        this.price = 3.75;
    }
    
    @Override
    public void ingredient()
    {
        in.add("White Chocolate");
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
