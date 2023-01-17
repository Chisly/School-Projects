A_score = 90
B_score = 80
C_score = 70
D_score = 60

score = int(input("Enter your test score from 0 to 99: "))

if score >= A_score:
    print('Your grade is A.')
elif score >= B_score:
    print('Your grade is B.')
elif score >= C_score:
    print('Your grade is C.')
elif score >= D_score:
    print('Your grade is D.')
else:
    print('Your grade is F.')