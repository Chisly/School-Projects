while True:
    user_in = int(input("Enter a number from 1 to 7: "))
    if user_in < 1 or user_in > 7:
        print("Invalid Entry.")
    else:
        break

if user_in == 1:
    print("Monday")
elif user_in == 2:
    print("Tuesday")
elif user_in == 3:
    print("Wednesday")
elif user_in == 4:
    print("Thursday")
elif user_in == 5:
    print("Friday")
elif user_in == 6:
    print("Saturday")
elif user_in == 7:
    print("Sunday")