from collections import deque
import sys

queue = deque([])
n = int(input())

for i in range(n):
    x = sys.stdin.readline().strip().split()

    if x[0] == 'push':
        queue.append(x[1])
    elif x[0] == 'pop':
        if not queue:
            print(-1)
        else:
            result = queue.popleft()
            print(int(result))
    elif x[0] == 'size':
        print(len(queue))
    elif x[0] == 'empty':
        if not queue:
            print(1)
        else:
            print(0)
    elif x[0] == 'front':
        if not queue:
            print(-1)
        else:
            print(int(queue[0]))
    elif x[0] == 'back':
        if not queue:
            print(-1)
        else:
            print(int(queue[-1]))