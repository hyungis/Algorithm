import sys
input = sys.stdin.readline
n = int(input())

s = set()
for i in range(n):
    x = input().split()
    if x[0] == 'add':
        s.add(int(x[1]))
    elif x[0] == 'remove':
        if int(x[1]) in s:
            s.remove(int(x[1]))
    elif x[0] == 'check':
        if int(x[1]) in s:
            print(1)
        else:
            print(0)
    elif x[0] == 'toggle':
        if int(x[1]) in s:
            s.remove(int(x[1]))
        else:
            s.add(int(x[1]))
    elif x[0] == 'all':
        s = set(i for i in range(1, 21))
    else:
        s = set()


