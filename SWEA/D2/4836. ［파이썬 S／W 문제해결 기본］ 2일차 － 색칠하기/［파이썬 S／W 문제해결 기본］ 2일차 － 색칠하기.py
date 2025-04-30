t = int(input())

for tc in range(1, t+1):
    n = int(input())
    arr = [[0]*10 for _ in range(10)]
    for _ in range(n):
        r1, c1, r2, c2, c = map(int, input().split())
        for i in range(r1, r2+1):
            for j in range(c1, c2+1):
                arr[i][j] += 1
    result = 0
    for i in arr:
        result += i.count(2)
    print(f'#{tc} {result}')