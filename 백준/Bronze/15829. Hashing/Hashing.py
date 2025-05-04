arr = '0abcdefghijklmnopqrstuvwxyz'
L = int(input())
x = input()
result = 0
for i in range(len(x)):
    result += arr.index(x[i]) * (31**i)

print(result)