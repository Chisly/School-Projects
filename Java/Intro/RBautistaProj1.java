/*
Ruben Bautista
CS 55 (Java)
Project 1
March 15, 2021
 */
package rbautistaproj1;

import java.util.Scanner;

public class RBautistaProj1 {
    
    public static void main(String[] args) 
    {
        filingStat();
    }
    
    public static void filingStat()
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter the filing status: ");
                        
        int userInput = scan.nextInt();
        
        if(userInput == 0)
            single(userInput); 
        else if(userInput == 1)
            marriedJoint(userInput);
        else if(userInput == 2)
            marriedSep(userInput);
        else if(userInput == 3)
            head(userInput);
        else
        {
            System.out.println("Invalid entry.\nPlease try again.\n");
            filingStat();
        }
    }
    
    public static void single(int x)
    {
        double taxAmount;
        double totaltaxAmount = 0;
        int update;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter your taxable income: ");
        
        int income = scan.nextInt();
        
        update = income;
        
        if(income > 8350)
        {
            taxAmount = 8350 * .10;
            totaltaxAmount += taxAmount;
            update -= 8350;
            
            if(income > 33950)
            {
                taxAmount = 25600 * .15;
                totaltaxAmount += taxAmount;
                update -= 25600;
                
                if(income > 82250)
                {
                    taxAmount = 48300 * .25;
                    totaltaxAmount += taxAmount;
                    update -= 48300;
                    
                    if(income > 171550)
                    {
                        taxAmount = 89300 * .28;
                        totaltaxAmount += taxAmount;
                        update -= 89300;
                        
                        if(income > 372950)
                        {
                            taxAmount = 201400 * .33;
                            totaltaxAmount += taxAmount;
                            update -= 201400;
                            
                            if(income >= 372951)
                            {
                                taxAmount = update * .35;
                                totaltaxAmount += taxAmount;
                                System.out.printf("Tax is %.2f\n", totaltaxAmount);
                            }
                        }
                        else
                        {
                            taxAmount = update * .33;
                            totaltaxAmount += taxAmount;
                            System.out.printf("Tax is %.2f\n", totaltaxAmount);
                        }
                    }
                    else
                    {
                        taxAmount = update * .28;
                        totaltaxAmount += taxAmount;
                        System.out.printf("Tax is %.2f\n", totaltaxAmount);
                    }
                }
                else
                {
                    taxAmount = update * .25;
                    totaltaxAmount += taxAmount;
                    System.out.printf("Tax is %.2f\n", totaltaxAmount);
                }
            }
            else
            {
                taxAmount = update * .15;
                totaltaxAmount += taxAmount;
                System.out.printf("Tax is %.2f\n", totaltaxAmount);
            }
        }
        else
        {
            taxAmount = update * .10;
            totaltaxAmount = taxAmount;
            System.out.printf("Tax is %.2f\n", totaltaxAmount);
        }
    }
    
    public static void marriedJoint(int x)
    {
        double taxAmount;
        double totaltaxAmount = 0;
        int update;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter your taxable income: ");
        
        int income = scan.nextInt();
        
        update = income;
        
        if(income > 16700)
        {
            taxAmount = 16700 * .10;
            totaltaxAmount += taxAmount;
            update -= 16700;
            
            if(income > 67900)
            {
                taxAmount = 51200 * .15;
                totaltaxAmount += taxAmount;
                update -= 51200;
                
                if(income > 137050)
                {
                    taxAmount = 69150 * .25;
                    totaltaxAmount += taxAmount;
                    update -= 69150;
                    
                    if(income > 208850)
                    {
                        taxAmount = 71800 * .28;
                        totaltaxAmount += taxAmount;
                        update -= 71800;
                        
                        if(income > 372950)
                        {
                            taxAmount = 164100 * .33;
                            totaltaxAmount += taxAmount;
                            update -= 164100;
                            
                            if(income >= 372951)
                            {
                                taxAmount = update * .35;
                                totaltaxAmount += taxAmount;
                                System.out.printf("Tax is %.2f\n", totaltaxAmount);
                            }
                        }
                        else
                        {
                            taxAmount = update * .33;
                            totaltaxAmount += taxAmount;
                            System.out.printf("Tax is %.2f\n", totaltaxAmount);
                        }
                    }
                    else
                    {
                        taxAmount = update * .28;
                        totaltaxAmount += taxAmount;
                        System.out.printf("Tax is %.2f\n", totaltaxAmount);
                    }
                }
                else
                {
                    taxAmount = update * .25;
                    totaltaxAmount += taxAmount;
                    System.out.printf("Tax is %.2f\n", totaltaxAmount);
                }
            }
            else
            {
                taxAmount = update * .15;
                totaltaxAmount += taxAmount;
                System.out.printf("Tax is %.2f\n", totaltaxAmount);
            }
        }
        else
        {
            taxAmount = update * .10;
            totaltaxAmount = taxAmount;
            System.out.printf("Tax is %.2f\n", totaltaxAmount);
        }
    }
    
    public static void marriedSep(int x)
    {
        double taxAmount;
        double totaltaxAmount = 0;
        int update;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter your taxable income: ");
        
        int income = scan.nextInt();
        
        update = income;
        
        if(income > 8350)
        {
            taxAmount = 8350 * .10;
            totaltaxAmount += taxAmount;
            update -= 8350;
            
            if(income > 33950)
            {
                taxAmount = 25600 * .15;
                totaltaxAmount += taxAmount;
                update -= 25600;
                
                if(income > 68525)
                {
                    taxAmount = 34575 * .25;
                    totaltaxAmount += taxAmount;
                    update -= 34575;
                    
                    if(income > 104425)
                    {
                        taxAmount = 35900 * .28;
                        totaltaxAmount += taxAmount;
                        update -= 35900;
                        
                        if(income > 186475)
                        {
                            taxAmount = 82050 * .33;
                            totaltaxAmount += taxAmount;
                            update -= 82050;
                            
                            if(income >= 186476)
                            {
                                taxAmount = update * .35;
                                totaltaxAmount += taxAmount;
                                System.out.printf("Tax is %.2f\n", totaltaxAmount);
                            }
                        }
                        else
                        {
                            taxAmount = update * .33;
                            totaltaxAmount += taxAmount;
                            System.out.printf("Tax is %.2f\n", totaltaxAmount);
                        }
                    }
                    else
                    {
                        taxAmount = update * .28;
                        totaltaxAmount += taxAmount;
                        System.out.printf("Tax is %.2f\n", totaltaxAmount);
                    }
                }
                else
                {
                    taxAmount = update * .25;
                    totaltaxAmount += taxAmount;
                    System.out.printf("Tax is %.2f\n", totaltaxAmount);
                }
            }
            else
            {
                taxAmount = update * .15;
                totaltaxAmount += taxAmount;
                System.out.printf("Tax is %.2f\n", totaltaxAmount);
            }
        }
        else
        {
            taxAmount = update * .10;
            totaltaxAmount = taxAmount;
            System.out.printf("Tax is %.2f\n", totaltaxAmount);
        }
    }
    
    public static void head(int x)
    {
        double taxAmount;
        double totaltaxAmount = 0;
        int update;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter your taxable income: ");
        
        int income = scan.nextInt();
        
        update = income;
        
        if(income > 11950)
        {
            taxAmount = 11950 * .10;
            totaltaxAmount += taxAmount;
            update -= 11950;
            
            if(income > 45500)
            {
                taxAmount = 33550 * .15;
                totaltaxAmount += taxAmount;
                update -= 33550;
                
                if(income > 117450)
                {
                    taxAmount = 71950 * .25;
                    totaltaxAmount += taxAmount;
                    update -= 71950;
                    
                    if(income > 190200)
                    {
                        taxAmount = 72750 * .28;
                        totaltaxAmount += taxAmount;
                        update -= 72750;
                        
                        if(income > 372950)
                        {
                            taxAmount = 182750 * .33;
                            totaltaxAmount += taxAmount;
                            update -= 182750;
                            
                            if(income >= 372951)
                            {
                                taxAmount = update * .35;
                                totaltaxAmount += taxAmount;
                                System.out.printf("Tax is %.2f\n", totaltaxAmount);
                            }
                        }
                        else
                        {
                            taxAmount = update * .33;
                            totaltaxAmount += taxAmount;
                            System.out.printf("Tax is %.2f\n", totaltaxAmount);
                        }
                    }
                    else
                    {
                        taxAmount = update * .28;
                        totaltaxAmount += taxAmount;
                        System.out.printf("Tax is %.2f\n", totaltaxAmount);
                    }
                }
                else
                {
                    taxAmount = update * .25;
                    totaltaxAmount += taxAmount;
                    System.out.printf("Tax is %.2f\n", totaltaxAmount);
                }
            }
            else
            {
                taxAmount = update * .15;
                totaltaxAmount += taxAmount;
                System.out.printf("Tax is %.2f\n", totaltaxAmount);
            }
        }
        else
        {
            taxAmount = update * .10;
            totaltaxAmount = taxAmount;
            System.out.printf("Tax is %.2f\n", totaltaxAmount);
        }
    }
}
