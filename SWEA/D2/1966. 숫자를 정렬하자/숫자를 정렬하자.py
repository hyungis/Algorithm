t = int(input())

for tc in range(1, t+1):
    n = int(input())
    li = list(map(int, input().split()))
    li.sort()
    print(f'#{tc}', end=' ')
    for i in li:
        print(i, end =" ")
    print()