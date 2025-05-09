import sys

n, m = map(int, sys.stdin.readline().strip().split())

arr = {}
arr1 = [sys.stdin.readline().strip() for _ in range(n)]
arr2 = [sys.stdin.readline().strip() for _ in range(m)]
for idx, x in enumerate(arr1):
    arr[idx+1] = x
arr3 = {name: idx+1 for idx, name in enumerate(arr1)}
for i in arr2:
    if i.isnumeric():
        print(arr[int(i)])
    else:
        print(arr3[i])
