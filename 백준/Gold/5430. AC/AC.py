import sys
from collections import deque

t = int(input())

for tc in range(t):
    p = sys.stdin.readline().rstrip()
    n = int(sys.stdin.readline())
    arr = sys.stdin.readline().rstrip()[1:-1].split(',')
    q = deque(arr)

    if n == 0:
        q = []
    flag = 0
    rev = 0
    for i in p:
        if i == 'R':
            rev += 1
        elif i == 'D':
            if len(q) < 1:
                flag = 1
                print("error")
                break
            else:
                if rev % 2 == 0:
                    q.popleft()
                else:
                    q.pop()
    if flag == 0:
        if rev % 2 == 0:
            print('['+','.join(q)+']')
        else:
            q.reverse()
            print('['+','.join(q)+']')