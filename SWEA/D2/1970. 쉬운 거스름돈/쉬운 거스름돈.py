t = int(input())

for tc in range(1, t+1):
    n = int(input())
    money = [50000, 10000, 5000, 1000, 500, 100, 50, 10]
    cnt = [0]*8
    for i in range(len(money)):
        if n // money[i] != 0:
            cnt[i] += n//money[i]
            n -= cnt[i]*money[i]
    print(f'#{tc}')
    print(*cnt)