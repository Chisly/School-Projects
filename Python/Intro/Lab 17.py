budget = float(input("Enter amount budgeted for a month: "))
print("Enter each expense for the month."
      + "\nEnter 'none' or 'done' when you have no more expenses to add.")
total = 0
i = 1
while True:
    try:
        expenses = float(input(f"Expense {i}: "))
        total += expenses
        i += 1
    except ValueError:
        break


if total > budget:
    print(f"\nAmount budgeted: ${budget}"
          + f"\nAmount spent: ${total}"
          + "\nYou are over budget")
else:
    print(f"\nAmount budgeted: ${budget}"
          + f"\nAmount spent: ${total}"
          + "\nYou are under budget")
