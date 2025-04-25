t = int(input())

for tc in range(1, t+1):
    n = int(input())
    li = [list(map(int, input().split())) for _ in range(n)]

    li_90 = [[0 for _ in range(n)] for _ in range(n)]
    li_180 = [[0 for _ in range(n)] for _ in range(n)]
    li_270 = [[0 for _ in range(n)] for _ in range(n)]

    for i in range(n):
        for j in range(n):
            li_90[i][j] = li[n-1-j][i]
    for i in range(n):
        for j in range(n):
            li_180[i][j] = li_90[n-1-j][i]
    for i in range(n):
        for j in range(n):
            li_270[i][j] = li_180[n-1-j][i]

    print(f'#{tc}')
    for i in range(n):
        for a in range(n):
            print(li_90[i][a], end='')
        print(end=' ')
        for b in range(n):
            print(li_180[i][b], end='')
        print(end=' ')
        for c in range(n):
            print(li_270[i][c], end='')
        print()