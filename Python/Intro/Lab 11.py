def determine_grade(score):
    if 90 <= score <= 100:
        return 'A'
    elif score >= 80:
        return 'B'
    elif score >= 70:
        return 'C'
    elif score >= 60:
        return 'D'
    else:
        return 'F'


def calc_average(score1, score2, score3, score4, score5):
    average = (score1 + score2 + score3 + score4 + score5)/5
    return average


while True:
    test1 = int(input("Enter a score for test #1 (1-100): "))
    if test1 < 1 or test1 > 100:
        print("Invalid Entry.")
    else:
        break
while True:
    test2 = int(input("Enter a score for test #2 (1-100): "))
    if test2 < 1 or test2 > 100:
        print("Invalid Entry.")
    else:
        break
while True:
    test3 = int(input("Enter a score for test #3 (1-100): "))
    if test3 < 1 or test3 > 100:
        print("Invalid Entry.")
    else:
        break
while True:
    test4 = int(input("Enter a score for test #4 (1-100): "))
    if test4 < 1 or test4 > 100:
        print("Invalid Entry.")
    else:
        break
while True:
    test5 = int(input("Enter a score for test #5 (1-100): "))
    if test5 < 1 or test5 > 100:
        print("Invalid Entry.")
    else:
        print("\nTest #1: " + determine_grade(test1))
        print("Test #2: " + determine_grade(test2))
        print("Test #3: " + determine_grade(test3))
        print("Test #4: " + determine_grade(test4))
        print("Test #5: " + determine_grade(test5))
        print(f"\nAverage Score: {calc_average(test1, test2, test3, test4, test5)}")
        break
