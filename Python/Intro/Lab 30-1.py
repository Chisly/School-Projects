with open('Numbers.txt', 'r') as num:
    total, added, avg = 0, 0, 0
    for line in num:
        conv = int(line)
        total += 1
        added += conv

    avg = added/total

    print(f"The sum is {added}.")
    print(f"There are {total} total integers in the .txt file.")
    print(f"Therefore the average is {avg}")
    num.close()
