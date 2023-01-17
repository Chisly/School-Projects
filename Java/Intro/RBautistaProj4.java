/*
Ruben Bautista
CS 55 (Java)
Project 4 (Computer Lab)
April 29, 2021
 */
package rbautistaproj4;

import java.util.Arrays;
import java.util.Scanner;

public class RBautistaProj4 {
    String labSeat[] = {"empty", "empty", "empty", "empty", "empty", "empty"};
    private static final RBautistaProj4 seats1 = new RBautistaProj4();
    private static final RBautistaProj4 seats2 = new RBautistaProj4();
    private static final RBautistaProj4 seats3 = new RBautistaProj4();
    private static final RBautistaProj4 seats4 = new RBautistaProj4();
    
    public static void main(String[] args) 
    {
        status("", 0, 0);
    }
    
    public static void menu()
    {
        Scanner scan = new Scanner(System.in);
        int input;
        System.out.println("\n\nMain Menu" + "\n0) Quit" + "\n1) Simulate Login" + "\n2) Simulate Logoff" + "\n3) Search");
        input = scan.nextInt();
        
        if(input == 0)
        {
            System.exit(0);
        }
        else if(input == 1)
        {
            login();
        }
        else if(input == 2)
        {
            logoff();
        }
        else if(input == 3)
        {
            search();
        }
        else
        {
            System.out.println("Invalid Entry. Try Again.");
            menu();
        }
    }
    
    public static void status(String idNum, int labIn, int comNum)
    {
        int labNum[] = {1, 2, 3, 4};
        
        //do if (labIn = 0) to remove id from status
        if(labIn == 1)
            seats1.labSeat[comNum-1] = idNum;
        else if(labIn == 2)
            seats2.labSeat[comNum-1] = idNum;
        else if(labIn == 3)
            seats3.labSeat[comNum-1] = idNum;
        else if(labIn == 4)
            seats4.labSeat[comNum-1] = idNum;
        
        System.out.println("\nLab #" + "\tComputer Stations\n");
        
        for(int i = 0; i < labNum.length; i++)
        {
            System.out.print(labNum[i]);
            
            if (i == 0)
            {
                for(int j = 0; j < 5; j++)
                {
                    System.out.print("\t" + (j+1) + ": " + seats1.labSeat[j]);
                }
                System.out.println();
            }
            else if (i == 1)
            {
                for(int j = 0; j < 6; j++)
                {
                    System.out.print("\t" + (j+1) + ": " + seats2.labSeat[j]);
                }
                System.out.println();
            }
            else if (i == 2)
            {
                for(int j = 0; j < 4; j++)
                {
                    System.out.print("\t" + (j+1) + ": " + seats3.labSeat[j]);
                }
                System.out.println();
            }
            else if (i == 3)
            {
                for(int j = 0; j < 3; j++)
                {
                    System.out.print("\t" + (j+1) + ": " + seats4.labSeat[j]);
                }
            }
        }
        menu();
    }
    
    public static void login()
    {
        Scanner scan = new Scanner(System.in);
        String idNum;
        int labNum;
        int comNum = 0;
        
        System.out.println("Enter the 5 digit ID number of the user logging in.");
        idNum = scan.nextLine();
        while(idNum.length() != 5)
        {
            System.out.println("Invalid Entry. Try Again.");
            idNum = scan.nextLine();
        }
        loginCheck(idNum);
        
        System.out.println("Enter the lab number the user is logging in from (1-4).");
        labNum = scan.nextInt();
        while(labNum < 1 || labNum > 4)
        {
            System.out.println("Invalid Entry. Try Again.");
            labNum = scan.nextInt();
        }
        
        if(labNum == 1)
        {
            System.out.println("Enter the computer station number the user is logging in to (1-5).");
            comNum = scan.nextInt();
            while(comNum < 1 || comNum > 5)
            {
                System.out.println("Invalid Entry. Try Again.");
                comNum = scan.nextInt();
            }
        }
        
        else if(labNum == 2)
        {
            System.out.println("Enter the computer station number the user is logging in to (1-6).");
            comNum = scan.nextInt();
            while(comNum < 1 || comNum > 6)
            {
                System.out.println("Invalid Entry. Try Again.");
                comNum = scan.nextInt();
            }
        }
        
        else if(labNum == 3)
        {
            System.out.println("Enter the computer station number the user is logging in to (1-4).");
            comNum = scan.nextInt();
            while(comNum < 1 || comNum > 4)
            {
                System.out.println("Invalid Entry. Try Again.");
                comNum = scan.nextInt();
            }
        }
        
        else if(labNum == 4)
        {
            System.out.println("Enter the computer station number the user is logging in to (1-3).");
            comNum = scan.nextInt();
            while(comNum < 1 || comNum > 3)
            {
                System.out.println("Invalid Entry. Try Again.");
                comNum = scan.nextInt();
            }
        }
        status(idNum, labNum, comNum);
    }
    public static void loginCheck(String check)
    {
        for(int i = 0; i < 5; i++)
        {
            if(check.equals(seats1.labSeat[i]))
            {
                System.out.println("User " + check + " is already logged in.\n" + "Try Again.");
                login();
            }
        }
        
        for(int i = 0; i < 6; i++)
        {
            if(check.equals(seats2.labSeat[i]))
            {
                System.out.println("User " + check + " is already logged in.\n" + "Try Again.");
                login();
            }
        }
        
        for(int i = 0; i < 4; i++)
        {
            if(check.equals(seats3.labSeat[i]))
            {
                System.out.println("User " + check + " is already logged in.\n" + "Try Again.");
                login();
            }
        }
        
        for(int i = 0; i < 3; i++)
        {
            if(check.equals(seats4.labSeat[i]))
            {
                System.out.println("User " + check + " is already logged in.\n" + "Try Again.");
                login();
            }
        }
    }
    
    public static void logoff()
    {
        Scanner scan = new Scanner(System.in);
        String idNum;
        
        System.out.println("Enter the 5 digit ID number of the user logging off.");
        idNum = scan.nextLine();
        while(idNum.length() != 5)
        {
            System.out.println("Invalid Entry. Try Again.");
            idNum = scan.nextLine();
        }
        
        for(int i = 0; i < 5; i++)
        {
            if(idNum.equals(seats1.labSeat[i]))
            {
                seats1.labSeat[i] = "empty";
                System.out.println("User " + idNum + " has logged off.");
            }
        }
        
        for(int i = 0; i < 6; i++)
        {
            if(idNum.equals(seats2.labSeat[i]))
            {
                seats2.labSeat[i] = "empty";
                System.out.println("User " + idNum + " has logged off.");
            }
        }
        
        for(int i = 0; i < 4; i++)
        {
            if(idNum.equals(seats3.labSeat[i]))
            {
                seats3.labSeat[i] = "empty";
                System.out.println("User " + idNum + " has logged off.");
            }
        }
        
        for(int i = 0; i < 3; i++)
        {
            if(idNum.equals(seats4.labSeat[i]))
            {
                seats4.labSeat[i] = "empty";
                System.out.println("User " + idNum + " has logged off.");
            }
        }
        status("",0 ,0 );
    }
    
    public static void search()
    {
        Scanner scan = new Scanner(System.in);
        String idNum;
        
        System.out.println("Enter the 5 digit ID number of the user to find.");
        idNum = scan.nextLine();
        while(idNum.length() != 5)
        {
            System.out.println("Invalid Entry. Try Again.");
            idNum = scan.nextLine();
        }
        
        for(int i = 0; i < 5; i++)
        {
            if(idNum.equals(seats1.labSeat[i]))
            {
                System.out.print("\nUser " + idNum + " is logged in Lab 1, Station " + (Arrays.asList(seats1.labSeat).indexOf(idNum)+1));
                menu();
            }
        }
        
        for(int i = 0; i < 6; i++)
        {
            if(idNum.equals(seats2.labSeat[i]))
            {
                System.out.print("\nUser " + idNum + " is logged in Lab 2, Station " + (Arrays.asList(seats2.labSeat).indexOf(idNum)+1));
                menu();
            }
        }
        
        for(int i = 0; i < 4; i++)
        {
            if(idNum.equals(seats3.labSeat[i]))
            {
                System.out.print("\nUser " + idNum + " is logged in Lab 3, Station " + (Arrays.asList(seats3.labSeat).indexOf(idNum)+1));
                menu();
            }
        }
        if(idNum.equals(seats4.labSeat[0]))
            System.out.print("\nUser " + idNum + " is logged in Lab 4, Station " + (Arrays.asList(seats4.labSeat).indexOf(idNum)+1));
        else if (idNum.equals(seats4.labSeat[1]))
            System.out.print("\nUser " + idNum + " is logged in Lab 4, Station " + (Arrays.asList(seats4.labSeat).indexOf(idNum)+1));
        else if (idNum.equals(seats4.labSeat[2]))
            System.out.print("\nUser " + idNum + " is logged in Lab 4, Station " + (Arrays.asList(seats4.labSeat).indexOf(idNum)+1));
        else
            System.out.print("\nUser " + idNum + " is not logged in");
        
        menu();
    }
}
