from collections import deque
n = int(input())
queue = deque([x for x in range(1, n+1)])

while 1:
    if len(queue) == 1:
        break
    queue.popleft()
    queue.append(queue[0])
    queue.popleft()
print(queue[0])