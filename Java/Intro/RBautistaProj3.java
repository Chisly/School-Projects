/*
Ruben Bautista
CS 55 (Java)
Project 3 (Find-Season)
March 29, 2021
 */
package rbautistaproj3;

import java.util.Scanner;

public class RBautistaProj3 {

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String input;
        
       do{ 
        System.out.println("Enter a date");
        input = scan.nextLine();
        
        String month = input.substring(0, input.indexOf(" "));
        String day = input.substring(input.indexOf(" ") + 1);
        
        int dayNum = Integer.parseInt(day);
        
        
        if (month.equals("January")||month.equals("january"))
        {
            if(dayNum >= 1 && dayNum <= 31)
                System.out.println("Winter");
            else
               System.out.println("Invalid");
        }
        else if(month.equals("February")||month.equals("february"))
        {
            if(dayNum >= 1 && dayNum <= 28)
                System.out.println("Winter");
            else
               System.out.println("Invalid");
        }
        else if(month.equals("March")||month.equals("march"))
        {
            if (dayNum >= 1 && dayNum <= 19)
                System.out.println("Winter");
            else if(dayNum >=20 && dayNum <= 31)
                System.out.println("Spring");
            else
                System.out.println("Invalid");            
        }
        else if(month.equals("April")||month.equals("april"))
        {
            if(dayNum >= 1 && dayNum <= 30)
                System.out.println("Spring");
            else
               System.out.println("Invalid");
        }
        else if(month.equals("May")||month.equals("may"))
        {
            if(dayNum >= 1 && dayNum <= 31)
                System.out.println("Spring");
            else
               System.out.println("Invalid");
        }
        else if(month.equals("June")||month.equals("june"))
        {
            if (dayNum >=1 && dayNum <= 20)
                System.out.println("Spring");
            else if (dayNum >=21 && dayNum <= 30)
                System.out.println("Summer");
            else
                System.out.println("Invalid");
        }
        else if(month.equals("July")||month.equals("july")||month.equals("August")||month.equals("august"))
        {
            if (dayNum >=1 && dayNum <= 31)
                System.out.println("Summer");
            else
                System.out.println("Invalid");
        }
        else if(month.equals("September")||month.equals("september"))
        {
            if (dayNum >=1 && dayNum <= 21)
                System.out.println("Summer");
            else if (dayNum >=22 && dayNum <= 30)
                System.out.println("Autumn");
            else
                System.out.println("Invalid");
        }
        else if(month.equals("October")||month.equals("october"))
        {
            if (dayNum >=1 && dayNum <= 31)
                System.out.println("Autumn");
            else
                System.out.println("Invalid");
        }
        else if(month.equals("November")||month.equals("november"))
        {
            if (dayNum >=1 && dayNum <= 30)
                System.out.println("Autumn");
            else
                System.out.println("Invalid");
        }
        else if(month.equals("December")||month.equals("december"))
        {
            if (dayNum >=1 && dayNum <= 20)
                System.out.println("Autumn");
            else if (dayNum >=21 && dayNum <= 31)
                System.out.println("Winter");
            else
                System.out.println("Invalid");
        }
        else
            System.out.println("Invalid");

       }while(!"Quit 0".equals(input));
    }
}
