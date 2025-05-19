n, m = map(int, input().split())
x, y, d = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(n)]
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

cnt = 0
while True:
    if arr[x][y] == 0:
        arr[x][y] = -1
        cnt += 1

    for _ in range(4):
        d = (d-1) % 4
        nx, ny = x + dx[d], y + dy[d]
        if 0 <= nx < n and 0 <= ny < m and arr[nx][ny] == 0:
            x, y = nx, ny
            break
    else:
        nx, ny = x + dx[d]*-1, y + dy[d]*-1
        if 0 <= nx < n and 0 <= ny < m and arr[nx][ny] == 1 or nx < 0 or nx >= n or ny < 0 or ny >= m:
            print(cnt)
            break
        else:
            x, y = nx, ny