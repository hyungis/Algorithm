t = int(input())

for tc in range(1, t+1):
    result = 0
    n = int(input())
    for j in range(1, n+1):
        if j % 2 == 1:
            result += j
        else:
            result -= j
    print(f'#{tc} {result}')
