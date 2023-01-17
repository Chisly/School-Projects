from matplotlib import pyplot as plt
from collections import defaultdict
import re 

def fileToDict(filename):
    store = defaultdict(list)
    gex = re.compile("[^@]+@[^@]+\.[^@]+")
    with open(filename, 'r') as f:
        for line in f:
            (email, value) = line.split()
            if(re.fullmatch(gex, email)):
                if(value.isnumeric()):
                    store[email].append(value)
                else:
                    store[email].append('invalid')
            else:
                store['invalid@email.com'].append(value)
        f.close()
        
    return dict(store)

def cleanUp(fileDict):
    cleanDict = {}
    for key in fileDict:
        temp = 0
        for item in fileDict[key]:
            if(item != 'invalid'):
                temp = temp + int(item)
        cleanDict[key] = temp 

    return cleanDict

def myPlot(cleanedFile):
    emails = list(cleanedFile.keys())
    nums = list(cleanedFile.values())

    plt.figure(figsize=(12,8))
    plt.bar(emails, nums)
    plt.show()

def main():
    filename = input("Enter a file name\n")

    fileDict = fileToDict(filename)

    cleanedFile = cleanUp(fileDict)

    myPlot(cleanedFile)

    choice = input("Do you wish to save the plot? Y or N\n")

    if choice.lower() == 'y':
        output = input("Enter a file name\n")
        plt.savefig(output)


if __name__ == "__main__":
    main()
