def change(n):
    if arr[n] == 0:
        arr[n] = 1
    else:
        arr[n] = 0
    return
n = int(input())
arr = [-1]+list(map(int, input().split()))
t = int(input())
for tc in range(t):
    a, b = map(int, input().split())
    if a == 1:
        for i in range(b, n+1, b):
            if arr[i] == 0:
                arr[i] = 1
            else:
                arr[i] = 0
    else:
        if arr[b] == 0:
            arr[b] = 1
        else:
            arr[b] = 0
        for i in range(1, n//2):
            if b - i < 1 or b + i > n:
                break
            if arr[b+i] == arr[b-i]:
                change(b+i)
                change(b-i)
            else:
                break

for i in range(1, n+1):
    print(arr[i], end=' ')
    if i % 20 == 0:
        print()

