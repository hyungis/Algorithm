for tc in range(1, 11):
    t = int(input())
    arr = list(map(int, input().split()))
    sum = 0

    for i in range(2, t-2):
        if arr[i] > arr[i-2] and arr[i] > arr[i-1] and arr[i] > arr[i+1] and arr[i] > arr[i+2]:
            sum += (arr[i] - max(arr[i-2], arr[i-1], arr[i+1], arr[i+2]))
    print(f'#{tc} {sum}')