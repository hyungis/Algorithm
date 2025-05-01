n = int(input())

result = n
for i in range(n):
    x = input()
    for j in range(len(x)-1):
        if x[j] == x[j+1]:
            continue
        else:
            if x[j] in x[j+1:]:
                result -= 1
                break
print(result)