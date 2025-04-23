t = int(input())

for i in range(1, t+1):
    n, m = map(int, input().split())
    li = list(map(int, input().split()))
    for j in range(m):
        x = li.pop(0)
        li.append(x)
    print(f'#{i} {li[0]}')