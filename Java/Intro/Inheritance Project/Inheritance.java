/*
Ruben Bautista
CS 55 (Java)
Project 6 (Inheritance)
May 24, 2021
 */
package inheritance;

import java.util.Scanner;

public class Inheritance 
{
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) 
    {
        Shape list = new Shape();
        int choice, quantity;
        double size, size2;
        do{
            System.out.println("Menu \n1) Create Rectangle(s) \n2) Create Square(s) \n3) Create Circle(s) \n4) Print Shapes(s) \n5) Quit ");
            System.out.println("Choose an option:");
            choice = scan.nextInt();
            if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
                System.out.println("Invalid Entry, Try Again");
                choice = scan.nextInt();
            } else {
                switch (choice)
                {
                    case 1:
                        System.out.println("How many rectangles do you want to create?");
                        quantity = scan.nextInt();
                        for(int i = 0; i < quantity; i++)
                        {
                            System.out.println("What is the length of Rectangle " + (i+1));
                            size = scan.nextInt();
                            scan.nextLine();
                            System.out.println("What is the width of Rectangle " + (i+1));
                            size2 = scan.nextInt();
                            scan.nextLine();
                            Rectangle rectangle = new Rectangle(size, size2);
                            list.add(rectangle);
                        }
                        break;
                    case 2:
                        System.out.println("How many squares do you want to create?");
                        quantity = scan.nextInt();
                        for(int i = 0; i < quantity; i++)
                        {
                            System.out.println("What is the size of Square " + (i+1));
                            size = scan.nextInt();
                            scan.nextLine();
                            Square square = new Square(size);
                            list.add(square);
                        }
                        break;
                    case 3:
                        System.out.println("How many circles do you want to create?");
                        quantity = scan.nextInt();
                        for(int i = 0; i < quantity; i++)
                        {
                            System.out.println("What is the size of Circle " + (i+1));
                            size = scan.nextInt();
                            scan.nextLine();
                            Circle circle = new Circle(size);
                            list.add(circle);
                        }
                        break;
                    case 4:
                        System.out.println();
                        list.print();
                        break;
                }
            }
            System.out.println();
        }while(choice != 5);
    }
    
}
