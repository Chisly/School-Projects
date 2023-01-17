def calc(in1, in2, in3, in4, in5, in6):
    monthly = (in1 + in2 + in3 + in4 + in5 + in6)
    annual = (monthly * 12)

    return "Monthly Cost: $" + str(monthly), "Annual Cost: $" + str(annual)


loan = float(input("Enter the monthly cost of loan payment: "))
ins = float(input("Enter the monthly cost of insurance: "))
gas = float(input("Enter the monthly cost of gas: "))
oil = float(input("Enter the monthly cost of oil "))
tires = float(input("Enter the monthly cost of tires "))
main = float(input("Enter the monthly cost of maintenance: "))

print(calc(loan, ins, gas, oil, tires, main))
