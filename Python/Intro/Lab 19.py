def find(word, letter):
    for i in range(len(word)):
        if word[i] == letter:
            return str(i)
    return "does not exist"


in1 = str(input("Enter a word: "))
in2 = str(input("Enter a letter to find: "))
print(f"The index of {in2} is {find(in1, in2)}")
