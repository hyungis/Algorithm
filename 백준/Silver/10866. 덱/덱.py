from collections import deque
import sys
queue = deque()
n = int(sys.stdin.readline().strip())
for _ in range(n):
    x = sys.stdin.readline().strip().split()
    if x[0] == 'push_front':
        queue.appendleft(int(x[1]))
    elif x[0] == 'push_back':
        queue.append(int(x[1]))
    elif x[0] == 'pop_front':
        if len(queue) == 0:
            print(-1)
        else:
            print(queue.popleft())
    elif x[0] == 'pop_back':
        if len(queue) == 0:
            print(-1)
        else:
            print(queue.pop())
    elif x[0] == 'size':
        print(len(queue))
    elif x[0] == 'empty':
        if len(queue) == 0:
            print(1)
        else:
            print(0)
    elif x[0] == 'front':
        if len(queue) == 0:
            print(-1)
        else:
            print(queue[0])
    elif x[0] == 'back':
        if len(queue) == 0:
            print(-1)
        else:
            print(queue[-1])
