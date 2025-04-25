t = int(input())

for tc in range(1, t+1):
    n = int(input())

    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    li = [[0]*n for _ in range(n)]
    cnt = 1
    x, y = 0, 0
    d = 0
    for _ in range(n*n):
        li[x][y] = cnt
        nx = x + dx[d]
        ny = y + dy[d]

        if nx < 0 or ny < 0 or nx >=n or ny >=n or li[nx][ny] != 0:
            d = (d+1)%4
            x += dx[d]
            y += dy[d]
        else:
            x, y = nx, ny
        cnt += 1
    print(f'#{tc}')
    for i in range(n):
        for j in range(n):
            print(li[i][j], end= ' ')
        print()