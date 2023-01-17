/**************
Ruben Bautista
CS 56 (Java)
Project 3
October 4, 2021
***************/
package storeassignment;

public class Recliner extends Furniture{
    
    public Recliner()
    {
        this.name = "Recliner";
        this.modelNr = 3849;
        this.price = 199.99;
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
