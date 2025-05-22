t = 10

for tc in range(1, t+1):
    n = int(input())
    arr = [list(map(int, input().split())) for _ in range(100)]
    result = []
    for i in range(100):
        cnt = 0
        cnt2 = 0
        for j in range(100):
            cnt += arr[i][j]
        result.append(cnt)
        for j in range(100):
            cnt2 += arr[j][i]
        result.append(cnt2)
    cnt3 = 0
    for i in range(100):
        cnt3 += arr[i][i]
    result.append(cnt3)
    cnt4 = 0
    for i in range(100):
        for j in range(99, -1, -1):
            if i + j == 99:
                cnt4 += arr[i][j]
    result.append(cnt4)
    print(f'#{tc} {max(result)}')