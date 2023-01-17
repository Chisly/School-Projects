from matplotlib import pyplot as plt 

def fill(x, y1, y2):
    with open('rainfallSet1.txt') as f:
        for line in f:
            num = line.split()
            x.append(num[0])
            y1.append(float(num[1]))
        f.close()

    with open('rainfallSet2.txt') as f:
        for line in f:
            num = line.split()
            y2.append(float(num[1]))
        f.close()
    
def findMaxMin(y):
    max = 0
    min = 1000
    for i in y:
        if i > max:
            max = i
            maxIndex = y.index(i)
        if i < min:
            min = i
            minIndex = y.index(i)
    return maxIndex, minIndex, max, min
        
def getPercent(y1, y2, y3):
    for i, j in zip(y1, y2):
        num = i - j
        num = (num/i)*100
        y3.append(float(num))

def compare(x, y1, y2, y3):
    plt.figure(figsize=(16,12))
    plt.plot(x, y3, label='% Decrease')
    plt.plot(x, y1, 'g-', marker='o', label='Before')
    plt.plot(x, y2, 'b-', marker='o', label='After')
    plt.legend(loc=9)
    plt.xlabel("Location", fontsize=16)
    plt.ylabel("Rain Amount", fontsize=16)
    plt.title("Rain Data", fontsize=16)
    plt.xticks(fontsize=12, rotation=90)
    plt.savefig('Comparison.png')

def single(x, y, outStr):
    maxIndex, minIndex, max, min = findMaxMin(y)
    plt.figure(figsize=(8,6))
    if(outStr == 'Before.png'):
        plt.plot(x, y, 'g-', marker='o', label='Before')
    else:
        plt.plot(x, y, 'b-', marker='o', label='After')
    plt.plot(maxIndex, max, 'r-', marker='o')
    plt.plot(minIndex, min, 'r-', marker='o', label='Max/Min')
    plt.legend(loc=5)
    plt.xlabel("Location", fontsize=16)
    plt.ylabel("Rain Amount", fontsize=16)
    plt.title("Rain Data", fontsize=16)
    plt.xticks(fontsize=12, rotation=90)
    plt.gca().set_ylim([0, 100])
    plt.savefig(f"{outStr}")

def main():
    x = []
    y1 = []
    y2 = []
    y3 = []
    
    fill(x, y1, y2)
    getPercent(y1, y2, y3)
    compare(x, y1, y2, y3)
    single(x, y1, 'Before.png')
    single(x, y2, 'After.png')
    plt.show()

if __name__ == "__main__":
    main()
