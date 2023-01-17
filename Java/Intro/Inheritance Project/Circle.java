/*
Ruben Bautista
CS 55 (Java)
Project 6 (Inheritance)
May 24, 2021
 */
package inheritance;

public class Circle extends Shape
{
    private double radius;
    private double area;
    public Circle()
    {
        this.radius = 0;
        this.area = 0;
    }
    
    public Circle(double radius)
    {
        this.radius = radius;
        this.area = (Math.PI * Math.pow(radius, 2));
    }
    
    double area()
    {
        return area;
    }

}
