arr = [list(map(int, input().split())) for _ in range(19)]

dx = [0, 1, 1, -1]
dy = [1, 0, 1, 1]
result = 0
for x in range(19):
    for y in range(19):
        if arr[x][y] != 0:
            focus = arr[x][y]

            for i in range(4):
                cnt = 1
                nx = x + dx[i]
                ny = y + dy[i]

                while 0 <= nx <= 18 and 0 <= ny <= 18 and arr[nx][ny] == focus:
                    cnt += 1

                    if cnt == 5:
                        if 0 <= x - dx[i] <= 18 and 0 <= y - dy[i] <= 18 and arr[x - dx[i]][y - dy[i]] == focus:
                            break
                        if 0 <= nx + dx[i] <= 18 and 0 <= ny + dy[i] <= 18 and arr[nx + dx[i]][ny + dy[i]] == focus:
                            break
                        if focus == 1:
                            result = 1
                        if focus == 2:
                            result = 2
                        a, b = x, y
                    nx += dx[i]
                    ny += dy[i]
if result > 0:
    print(result)
    print(a+1, b+1)
else:
    print(0)