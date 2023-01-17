/*
Ruben Bautista
CS 55 (Java)
Project 6 (Inheritance)
May 24, 2021
 */
package inheritance;

public class Square extends Shape
{
    private double size;
    private double area;
    public Square()
    {
        this.size = 0;
        this.area = 0;
    }
    
    public Square(double size)
    {
        this.size = size;
        this.area = Math.pow(size, 2);
    }
    
    double area()
    {
        return area;
    }
}
