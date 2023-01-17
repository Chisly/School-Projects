/*
Ruben Bautista
CS 55 (Java)
Project 7 (Polymorphic)
May 31, 2021
 */
package polymorphic;

import java.util.ArrayList;
import java.util.Scanner;

public class Polymorphic 
{
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) 
    {
        ArrayList<Coffee> cart = new ArrayList<>();
        int choice, quantity;
        String in;
        double syrupA;
        String sName;
        do{
            System.out.println("Menu \n1) Order White Chocolate Mocha(s) \n2) Order Dark Chocolate Mocha(s) \n3) Order Peppermint Mocha(s) \n4) Create Coffee Mocha(s) \n5) Print Coffee(s) \n6) Quit ");
            System.out.println("Choose an option:");
            choice = scan.nextInt();
            scan.nextLine();
            if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6) {
                System.out.println("Invalid Entry, Try Again");
                choice = scan.nextInt();
                scan.nextLine();
            } else {
                switch (choice)
                {
                    case 1:
                        System.out.println("What coffee shop do you want to order from?");
                        sName = scan.nextLine();
                        System.out.println("How many White Chocolate Mochas do you want to create?");
                        quantity = scan.nextInt();
                        scan.nextLine();
                        for(int i = 0; i < quantity; i++)
                        {
                            WhiteChocolateMocha wMocha = new WhiteChocolateMocha(sName);
                            cart.add(wMocha);
                        }
                        break;
                    case 2:
                        System.out.println("What coffee shop do you want to order from?");
                        sName = scan.nextLine();
                        System.out.println("How many Dark Chocolate Mochas do you want to create?");
                        quantity = scan.nextInt();
                        scan.nextLine();
                        for(int i = 0; i < quantity; i++)
                        {
                            DarkChocolateMocha dMocha = new DarkChocolateMocha(sName);
                            cart.add(dMocha);
                        }
                        break;
                    case 3:
                        System.out.println("What coffee shop do you want to order from?");
                        sName = scan.nextLine();
                        System.out.println("How many Peppermint Mochas do you want to create?");
                        quantity = scan.nextInt();
                        scan.nextLine();
                        for(int i = 0; i < quantity; i++)
                        {
                            PeppermintMocha pMocha = new PeppermintMocha(sName);
                            System.out.println("How mnay tablespoons of peppermint syrup would you like for Peppermint Mocha " + (i+1) + "?");
                            syrupA = scan.nextDouble();
                            scan.nextLine();
                            pMocha.setSyrup(syrupA);
                            cart.add(pMocha);
                        }
                        break;
                    case 4:
                        System.out.println("What coffee shop do you want to order from?");
                        sName = scan.nextLine();
                        System.out.println("How many custom Coffee Mochas do you want to create?");
                        quantity = scan.nextInt();
                        scan.nextLine();
                        for(int i = 0; i < quantity; i++)
                        {
                            CoffeeMocha cMocha = new CoffeeMocha(sName);
                            System.out.println("What are the ingredients for Coffee Mocha " + (i+1));
                            System.out.println("Enter 'done' when finished");
                            do{
                                in = scan.nextLine();
                                if(in.equals("done") || in.equals("Done"))
                                {
                                    System.out.println("Finished adding ingredients.");
                                    cart.add(cMocha);
                                }
                                else
                                    cMocha.setIn(in);
                            }while(!(in.equals("done") && !(in.equals("Done"))));
                        }
                        break;
                    case 5:
                        int i = 0, w = 1, d = 1, p = 1, c = 1;
                        System.out.println();
                        for(Coffee item : cart)
                        {
                            if(item.getClass() == WhiteChocolateMocha.class)
                            {
                                System.out.print("(" + item.storeName + ") " + item.coffeeType + " " + w + ": $");
                                System.out.printf("%.2f\n", item.price);
                                item.prepare();
                                System.out.println();
                                i++;
                                w++;
                            }
                            else if(item.getClass() == DarkChocolateMocha.class)
                            {
                                System.out.print("(" + item.storeName + ") " + item.coffeeType + " " + d + ": $");
                                System.out.printf("%.2f\n", item.price);
                                item.prepare();
                                System.out.println();
                                i++;
                                d++;
                            }
                            else if(item.getClass() == PeppermintMocha.class)
                            {
                                System.out.print("(" + item.storeName + ") " + item.coffeeType + " " + p + ": $");
                                System.out.printf("%.2f\n", item.price);
                                item.prepare();
                                System.out.println();
                                i++;
                                p++;
                            }
                            else if(item.getClass() == CoffeeMocha.class)
                            {
                                System.out.print("(" + item.storeName + ") " + item.coffeeType + " " + c + ": $");
                                System.out.printf("%.2f\n", item.price);
                                item.prepare();
                                System.out.println();
                                i++;
                                c++;
                            }
                        }
                        break;
                }
            }
            System.out.println();
        }while(choice != 6);
    }
}
