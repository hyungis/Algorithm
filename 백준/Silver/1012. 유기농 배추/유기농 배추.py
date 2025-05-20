import sys
sys.setrecursionlimit(10000)

def dfs(x, y):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < n and 0 <= ny < m and arr[nx][ny] == 1:
            arr[nx][ny] = 0
            dfs(nx, ny)
t = int(input())

for _ in range(t):
    m, n, k = map(int, sys.stdin.readline().split())
    arr = [[0 for _ in range(m)] for _ in range(n)]
    cnt = 0
    for _ in range(k):
        y, x = map(int, sys.stdin.readline().split())
        arr[x][y] = 1
    for i in range(n):
        for j in range(m):
            if arr[i][j] > 0:
                dfs(i, j)
                cnt += 1
    print(cnt)
