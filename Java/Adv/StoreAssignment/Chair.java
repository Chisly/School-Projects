/**************
Ruben Bautista
CS 56 (Java)
Project 3
October 4, 2021
***************/
package storeassignment;

public class Chair extends Furniture{
    
    public Chair()
    {
        this.name = "Chair";
        this.modelNr = 9867;
        this.price = 59.99;
    }
    
    public String getName() {
        return name;
    }

    public int getModelNr() {
        return modelNr;
    }

    public double getPrice() {
        return price;
    }
    
}
