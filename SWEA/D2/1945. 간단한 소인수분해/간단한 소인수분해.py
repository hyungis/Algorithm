t = int(input())
for tc in range(1, t+1):
    di = {2: 0, 3: 0, 5: 0, 7: 0, 11: 0}
    n = int(input())
    while n > 1:
        if n % 2 == 0:
            n = n//2
            di[2] += 1
        elif n % 3 == 0:
            n = n//3
            di[3] += 1
        elif n % 5 == 0:
            n = n//5
            di[5] += 1
        elif n % 7 == 0:
            n = n//7
            di[7] += 1
        elif n % 11 == 0:
            n = n//11
            di[11] += 1
    print(f'#{tc} {di[2]} {di[3]} {di[5]} {di[7]} {di[11]}')