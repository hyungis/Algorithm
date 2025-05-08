from collections import deque
t = int(input())

for tc in range(t):
    n, m = map(int, input().split())
    queue = deque(map(int, input().split()))
    result = 1
    while queue:
        if queue[0] < max(queue):
            queue.append(queue.popleft())
        else:
            if m == 0:
                break
            queue.popleft()
            result += 1
        if m > 0:
            m = m - 1
        else:
            m = len(queue) - 1
    print(result)
