/*
Ruben Bautista
CS 55 (Java)
Project 6 (Inheritance)
May 24, 2021
 */
package inheritance;

public class Rectangle extends Shape
{
    private double length;
    private double width;
    private double area;
    public Rectangle()
    {
        this.length = 0;
        this.width = 0;
        this.area = 0;
    }
    
    public Rectangle(double length, double width)
    {
        this.length = length;
        this.width = width;
        this.area = (length * width);
    }
    
    double area()
    {
        return area;
    }
}
