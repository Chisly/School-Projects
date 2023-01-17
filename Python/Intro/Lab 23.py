import random

lot = []

for i in range(7):
    num = random.randint(0, 9)
    lot.append(num)


print("Lottery Number: ", end="")
for j in lot:
    print(j, end="")
