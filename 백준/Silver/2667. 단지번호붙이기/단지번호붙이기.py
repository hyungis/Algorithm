from collections import deque

n = int(input())
arr = [list(map(int, input())) for _ in range(n)]
result = []
def bfs(arr,x,y):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    q = deque()
    q.append((x,y))
    arr[x][y] = 0
    cnt = 1
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            if arr[nx][ny] == 1:
                arr[nx][ny] = 0
                q.append((nx,ny))
                cnt += 1
    return cnt
for i in range(n):
    for j in range(n):
        if arr[i][j] == 1:
            result.append(bfs(arr, i, j))
print(len(result))
for i in sorted(result):
    print(i)