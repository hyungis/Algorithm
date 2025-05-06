import sys
n = int(sys.stdin.readline())
li = set(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
li2 = list(map(int, sys.stdin.readline().split()))
for i in li2:
    if i in li:
        print(1)
    else:
        print(0)