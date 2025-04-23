t = int(input())
for tc in range(1, t+1):
    di = {2: 0, 3: 0, 5: 0, 7: 0, 11: 0}
    n = int(input())
    d = 2
    while d <= n:
        if n % d == 0:
            di[d] += 1
            n /= d
        else:
            d += 1
    print(f'#{tc} {di[2]} {di[3]} {di[5]} {di[7]} {di[11]}')