import sys

n, m = map(int, sys.stdin.readline().split())
arr1 = set([sys.stdin.readline().strip() for _ in range(n)])
arr2 = [sys.stdin.readline().strip() for _ in range(m)]
result = []
for i in arr2:
    if i in arr1:
        result.append(i)
print(len(result))
for i in sorted(result):
    print(i)