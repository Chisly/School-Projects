total = 0
for i in range(5):
    in1 = int(input("Enter number of bugs collected in day " + str(i+1) + ": "))
    total += in1


print(f"\nTotal number of bugs collected: {total}")
