def max(num1, num2):
    if num1 > num2:
        return "Greater number is " + str(num1)
    elif num1 < num2:
        return "Greater number is " + str(num2)
    else:
        return "Numbers are equal"


in1 = int(input("Enter a number: "))
in2 = int(input("Enter a number: "))
print(max(in1, in2))