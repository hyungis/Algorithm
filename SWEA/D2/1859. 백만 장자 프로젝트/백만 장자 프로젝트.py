t = int(input())

for tc in range(1, t+1):
    n = int(input())
    arr = list(map(int, input().split()))
    arr.reverse()
    max_value = 0
    result = 0
    for i in arr:
        if i >= max_value:
            max_value = i
        else:
            result += max_value-i
    print(f'#{tc} {result}')