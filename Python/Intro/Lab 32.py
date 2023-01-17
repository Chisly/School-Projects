import os.path
try:
    filename = input("What test file to open? ")
    file = open(filename)
    print("File found")
    file.close()
except FileNotFoundError:
    print("File not found")
