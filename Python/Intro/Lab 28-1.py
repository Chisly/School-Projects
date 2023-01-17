with open('Numbers.txt', 'r') as num:
    for line in num:
        print(line, end='')

    num.close()
