num = str(input("Enter a series of single-digit numbers: "))

total = 0
for i in range(len(num)):
    total += int(num[i])
print(total)
