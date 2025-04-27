t = int(input())

for tc in range(1, t+1):
    n, m = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(n)]
    prefix = [[0]*(n+1) for _ in range(n+1)]

    for i in range(1, n+1):
        for j in range(1, n+1):
            prefix[i][j] = arr[i-1][j-1] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1]

    max_cnt = 0

    for i in range(m, n+1):
        for j in range(m, n+1):
            cnt = prefix[i][j] - prefix[i-m][j] - prefix[i][j-m] + prefix[i-m][j-m]
            if max_cnt < cnt:
                max_cnt = cnt
    print(f'#{tc} {max_cnt}')
