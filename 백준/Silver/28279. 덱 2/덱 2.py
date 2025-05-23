from collections import deque
import sys

q = deque()
n = int(sys.stdin.readline())
for _ in range(n):
    x = sys.stdin.readline().rstrip().split()
    if x[0] == '1':
        q.appendleft((int(x[1])))
    elif x[0] == '2':
        q.append(int(x[1]))
    elif x[0] == '3':
        if q:
            print(q.popleft())
        else:
            print(-1)
    elif x[0] == '4':
        if q:
            print(q.pop())
        else:
            print(-1)
    elif x[0] == '5':
        print(len(q))
    elif x[0] == '6':
        if q:
            print(0)
        else:
            print(1)
    elif x[0] == '7':
        if q:
            print(q[0])
        else:
            print(-1)
    elif x[0] == '8':
        if q:
            print(q[-1])
        else:
            print(-1)