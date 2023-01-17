with open('Numbers.txt', 'r') as num:
    total, chars = 0, 0
    for line in num:
        count = sum(c.isdigit() for c in line)
        total += 1
        chars += count

    print(f"There are {total} total integers in the .txt file.")
    print(f"There are {chars} total characters in the .txt file.")
    num.close()
