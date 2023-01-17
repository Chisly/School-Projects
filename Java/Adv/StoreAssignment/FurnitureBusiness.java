/**************
Ruben Bautista
CS 56 (Java)
Project 3
October 4, 2021
***************/
package storeassignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FurnitureBusiness {
    public HashMap<Customer, List<Furniture>> records = new HashMap<>();
    
    public void purchase(Customer c, Furniture f){
        if(!records.containsKey(c)){
            List<Furniture> cart = new ArrayList();
            cart.add(f);
            records.put(c, cart);
        }
        else{
            getPurchases(c).add(f);
        }
    }
    
    public boolean hasBought(Customer c, Furniture f){
        if(records.containsKey(c) && getPurchases(c).contains(f))
        {
            return true;
        }
        else{
            return false;
        }
    }
    
    public List<Furniture> getPurchases(Customer c){
        return records.get(c);
    }
}
