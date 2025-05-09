n = int(input())

arr = sorted(list(map(int, input().split())))
result = 0
x = 0
for i in arr:
    x += i
    result += x

print(result)