def calc_smc(num1, num2):
    added = num1 + num2
    subbed = num1 - num2

    return "Sum is " + str(added), "Difference is " + str(subbed)


in1 = int(input("Enter a number: "))
in2 = int(input("Enter a number to add/subtract: "))

print(calc_smc(in1, in2))
