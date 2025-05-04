import sys
n = int(sys.stdin.readline())
arr = [sys.stdin.readline().rstrip() for _ in range(n)]

arr = list(set(arr))
arr.sort()
arr.sort(key = len)

for i in arr:
    print(i)