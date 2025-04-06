import sys

n = int(input())
li = [int(sys.stdin.readline()) for _ in range(n)]
li.sort()

for i in li:
    print(i)