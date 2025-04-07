import sys

n = int(input())
li = []
for _ in range(n):
    a, b = sys.stdin.readline().split()
    li.append([a, b])

li.sort(key = lambda x: int(x[0]))

for i in li:
    print(i[0], i[1])