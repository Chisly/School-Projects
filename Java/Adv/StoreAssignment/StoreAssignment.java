/**************
Ruben Bautista
CS 56 (Java)
Project 3
October 4, 2021
***************/
package storeassignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class StoreAssignment {
    private static Scanner scan = new Scanner(System.in);
    private static Random rand = new Random();
    private static FurnitureBusiness fb = new FurnitureBusiness();
    
    public static void main(String[] args) {
        List<Customer> people = new ArrayList();
        List<Furniture> inStock = new ArrayList();
        Furniture chair1 = new Chair();
        Furniture chair2= new Chair();
        Furniture chair3 = new Chair();
        Furniture recliner = new Recliner();
        Furniture table = new Table();
        inStock.add(chair1);
        inStock.add(chair2);
        inStock.add(chair3);
        inStock.add(recliner);
        inStock.add(table);
        
        
        Customer one = new Customer();
        one.setName("Carl");
        one.setAddress("8468 Essex Dr. Stoughton, MA 02072");
        int id = rand.nextInt(5000);
        id += 1000;
        one.setID(id);
        fb.purchase(one, chair2);
        
        
        Customer two = new Customer();
        two.setName("Tom");
        two.setAddress("44 Circle Dr. Chattanooga, TN 37421");
        id = rand.nextInt(5000);
        id += 1000;
        two.setID(id);
        fb.purchase(two, chair1);
        
        Customer three = new Customer();
        three.setName("William");
        three.setAddress("26 Rose Dr. Southampton, PA 18966");
        id = rand.nextInt(5000);
        id += 1000;
        three.setID(id);
        fb.purchase(three, chair3);
        fb.purchase(three, table);
        fb.purchase(three, recliner);
        
        people.add(one);
        people.add(two);
        people.add(three);
        
        for(Customer person : people)
        {
            int temp = 0;
            System.out.println("Customer name: " + person.name);
            
            for(Furniture item : inStock)
            {
                if(item.getClass() == Chair.class && temp == 0 && fb.hasBought(person, item) == true)
                {
                    System.out.println("Item: " + item.name 
                            + "\nStatus: Bought");
                    
                    temp++;
                }
                else if(item.getClass() != Chair.class && fb.hasBought(person, item) == true)
                {
                    
                    System.out.println("Item: " + item.name 
                            + "\nStatus: Bought");
                }
                else
                {
                    System.out.println("Item: " + item.name 
                            + "\nStatus: Not Bought");
                }
            }
            System.out.println();
        }
        
       for(Customer person : people)
        {
            System.out.print("\nCustomer name: " + person.name 
                    + "\nPurchases: ");
            for (Furniture item : fb.getPurchases(person)) {
                System.out.print(item.name + ", ");
            }
        }
       System.out.println();
    }
}