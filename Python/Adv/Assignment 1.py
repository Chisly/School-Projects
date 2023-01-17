import turtle
from turtle import *

def drawFlower(self, numOfSquares=0):
    deg = 360/numOfSquares
    self.color("violet", "pink")
    self.width(2)
    self.begin_fill()
    self.speed(0)
    self.left(deg)
    for i in range(numOfSquares):        
        for j in range(4):
            self.forward(350)
            self.right(90)
        self.left(deg)
    self.end_fill()


def main():
    Turtle.TurtleFlower = drawFlower
    num = int(input("Enter number of squares for your flower: "))
    first = turtle.Turtle()
    first.TurtleFlower(num)
    turtle.done()


if __name__ == "__main__":
    main()
