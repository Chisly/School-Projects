/*
Ruben Bautista
CS 55 (Java)
Project 6 (Inheritance)
May 24, 2021
 */
package inheritance;

import java.util.ArrayList;

public class Shape
{
    public ArrayList<Shape> ar = new ArrayList<>();
    double area()
    {
        double area = 0.0;
        
        return area;
    }
    public void add(Rectangle shape)
    {
        ar.add(shape);
    }
    public void add(Square shape)
    {
        ar.add(shape);
    }
    public void add(Circle shape)
    {
        ar.add(shape);
    }
    public void print()
    {
        int i = 1, j = 1, k = 1;
        for (Shape shape : ar) {
            if(shape.getClass() == Rectangle.class)
            {
                System.out.print("Rectangle " + i + ": ");
                System.out.printf("%.2f\n", shape.area());
                i++;
            }
            else if(shape.getClass() == Square.class)
            {
                System.out.print("Square " + j + ": ");
                System.out.printf("%.2f\n", shape.area());
                j++;
            }
            else if(shape.getClass() == Circle.class)
            {
                System.out.print("Circle " + k + ": ");
                System.out.printf("%.2f\n", shape.area());
                k++;
            }
        }
    }
}
