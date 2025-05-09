import sys

n, m = map(int, sys.stdin.readline().split())

arr = {}
for _ in range(n):
    site, pw = sys.stdin.readline().strip().split()
    arr[site] = pw
result = []
for i in range(m):
    x = sys.stdin.readline().strip()
    result.append(arr[x])

for i in result:
    print(i)