/*
Ruben Bautista
CS 55 (Java)
Project 6 (Inheritance)
May 24, 2021
 */
package polymorphic;

public class PeppermintMocha extends Coffee
{
    private double peppermintSyrupAmount;
    public PeppermintMocha()
    {}
    
    public PeppermintMocha(String sName)
    {
        this.coffeeType = "Peppermint Mocha";
        this.storeName = sName;
        this.price = 4;
    }
    
    public void setSyrup(double tbs)
    {
        this.peppermintSyrupAmount = tbs;
    }
    
    public double getSyrup()
    {
        return peppermintSyrupAmount;
    }
    
    @Override
    public void ingredient()
    {
        in.add("Peppermint Syrup");
        in.add("Brewed Espresso");
        in.add("Whipped Cream");
        in.add("Mocha Sauce");
        in.add("Milk");
    }
    
    @Override
    public void prepare()
    {
        ingredient();
        System.out.println("Syrup Amount(tbs): " + peppermintSyrupAmount);
        System.out.println(in);
    }
}
