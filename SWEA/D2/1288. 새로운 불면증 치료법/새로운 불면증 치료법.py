t = int(input())

for tc in range(1, t+1):
    s = set()
    n = int(input())
    base = n
    result = 0
    while len(s) < 10:
        for i in str(n):
            s.add(i)
        result += 1
        n += base
    print(f'#{tc} {result*base}')
