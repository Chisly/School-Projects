num1 = int(input('Enter a number: '))
num2 = int(input('Enter another number: '))

if num2 == 0:
    print("Cannot divide by zero.")
else:
    result = num1/num2
    print(f'{num1} divided by {num2} is {result}')
