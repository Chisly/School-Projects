/*
Ruben Bautista
CS 55 (Java)
Project 2 (Format-Name)
March 22, 2021
 */
package rbautistaproj2;

import java.util.Scanner;

public class RBautistaProj2 {

    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please enter your first name.");
        String firstName = scan.nextLine();
        System.out.println("Please enter your middle name. (If any)");
        String middleName = scan.nextLine();
        System.out.println("Please enter your last name.");
        String lastName = scan.nextLine();
        
        String firstInitial = firstName.substring(0, 1);
        
        if(middleName.isEmpty())
        {
            System.out.println("\n" + lastName + ", " + firstInitial + ".");
        }
        else
        {
            String middleInitial = middleName.substring(0, 1);
            System.out.println("\n" + lastName + ", " + firstInitial + "." + middleInitial + ".");
        }
    }
}
