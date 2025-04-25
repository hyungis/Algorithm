t = int(input())

for tc in range(1, t+1):
    n, m = map(int, input().split())
    arr = list(map(int, input().split()))
    result = []
    for i in range(n-m+1):
        result.append(sum(arr[i:m+i]))
    print(f'#{tc} {max(result)-min(result)}')