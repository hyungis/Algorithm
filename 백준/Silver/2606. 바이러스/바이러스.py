from collections import deque

n = int(input())
m = int(input())

arr = [[]for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    arr[a].append(b)
    arr[b].append(a)
visited = [False]*(n+1)
visited[1] = True
def bfs(v):
    queue = deque()
    queue.append(v)

    while queue:
        x = queue.popleft()
        for i in arr[x]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
bfs(1)
print(visited.count(True)-1)