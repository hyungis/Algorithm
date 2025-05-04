n = int(input())
arr = [input() for _ in range(n)]

arr = list(set(arr))
arr.sort()
arr.sort(key = len)

for i in arr:
    print(i)