def nested_sum(t):
    total = 0
    for i in t:
        for j in i:
            total += j

    return total


e = [[1, 2], [3], [4, 5, 6], [3, 4, 2, 6]]

print(nested_sum(e))
