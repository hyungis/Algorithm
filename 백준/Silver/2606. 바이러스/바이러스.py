import sys
from collections import deque

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())

arr = [[] for _ in range(n+1)]
for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    arr[a].append(b)
    arr[b].append(a)
visited = [False for _ in range(n+1)]
q = deque()
q.append(1)
visited[1] = True
result = 0
while q:
    cur = q.popleft()
    for val in arr[cur]:
        if visited[val] == False:
            q.append(val)
            visited[val] = True
            result += 1

print(result)

