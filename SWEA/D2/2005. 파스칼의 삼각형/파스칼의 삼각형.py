t = int(input())

for tc in range(1, t+1):
    n = int(input())
    arr = [[0]*n for _ in range(n)]

    for i in range(n):
        for j in range(i+1):
            if i == 0 or i == j:
                arr[i][j] = 1
            else:
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j]

    print(f'#{tc}')
    for x in range(n):
        for y in range(n):
            if arr[x][y]:
                print(arr[x][y], end=' ')
        print()