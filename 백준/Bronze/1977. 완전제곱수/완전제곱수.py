n = int(input())
m = int(input())

arr = [0]*10001
result = []
for i in range(101):
    arr[i**2] = 1

for i in range(n, m+1):
    if arr[i] == 1:
        result.append(i)
if not result:
    print(-1)
else:
    print(sum(result))
    print(min(result))