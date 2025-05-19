from collections import deque

def dfs(v):
    visited[v] = True
    print(v, end=' ')
    for i in arr[v]:
        if not visited[i]:
            dfs(i)

def bfs(v):
    queue = deque([v])
    visited[v] = True
    while queue:
        x = queue.popleft()
        print(x, end=' ')
        for i in arr[x]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)


n, m, v = map(int, input().split())

arr = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    arr[a].append(b)
    arr[b].append(a)
for i in arr:
    i.sort()

visited = [False]*(n+1)
dfs(v)
print()

visited = [False]*(n+1)
bfs(v)
