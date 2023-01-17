myDict = {'a': 1, 'b': 2, 'c': 3, 'd': 4}
print(myDict)

uin = str(input("Enter key you wish to delete: "))

# Used dict.pop() instead of del dict[] to avoid KeyError
myDict.pop(uin, None)

print(myDict)
