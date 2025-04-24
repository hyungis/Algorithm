t = int(input())

for tc in range(1, t+1):
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    result = []
    if n < m:
        for i in range(m-n+1):
            cnt = 0
            for j in range(n):
                cnt += a[j]*b[i+j]
            result.append(cnt)
    else:
        for i in range(n-m+1):
            cnt = 0
            for j in range(m):
                cnt += b[j]*a[i+j]
            result.append(cnt)
    print(f'#{tc} {max(result)}')

