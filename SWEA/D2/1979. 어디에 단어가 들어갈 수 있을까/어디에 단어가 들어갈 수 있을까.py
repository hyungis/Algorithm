t = int(input())

for tc in range(1, t+1):
    n, k = map(int, input().split())
    li = [list(map(int, input().split())) for _ in range(n)]
    result = 0

    for i in range(n):
        sum = 0
        for j in range(n):
            if li[i][j] == 1:
                sum += 1
            if li[i][j] == 0 or j == n-1:
                if sum == k:
                    result += 1
                sum = 0

        for j in range(n):
            if li[j][i] == 1:
                sum += 1
            if li[j][i] == 0 or j == n-1:
                if sum == k:
                    result += 1
                sum = 0
    print(f'#{tc} {result}')