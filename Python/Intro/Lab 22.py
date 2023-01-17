sales = []
total = 0
print("Enter a store's sales for each day of the week")

for i in range(7):
    add = int(input("Day " + str(i+1) + ": "))

    sales.append(add)


for j in sales:
    total += j


print(f"\nThe store's total sales for the week is ${total}")
