t = int(input())

for tc in range(1, t+1):
    n = int(input())

    arr = [list(map(int, input())) for _ in range(n)]
    answer = 0
    for i in range(n//2):
        answer += sum(arr[i][n//2-i : n-n//2+i])
        answer += sum(arr[n-1-i][n//2-i: n-n//2+i])

    for i in range(n):
        answer += arr[n//2][i]
    print(f'#{tc} {answer}')