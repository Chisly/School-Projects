def feet_to_inches(feet):
    inches = (feet * 12)

    return "There are " + str(inches) + " inches in " + str(feet) + " feet"


in1 = int(input("Enter a number of feet to convert to inches: "))

print(feet_to_inches(in1))
