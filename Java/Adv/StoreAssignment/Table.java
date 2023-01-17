/**************
Ruben Bautista
CS 56 (Java)
Project 3
October 4, 2021
***************/
package storeassignment;

public class Table extends Furniture {
    
    public Table()
    {
        this.name = "Table";
        this.modelNr = 4738;
        this.price = 79.99;
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
