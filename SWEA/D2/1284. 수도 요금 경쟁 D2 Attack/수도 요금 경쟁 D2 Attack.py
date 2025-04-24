t = int(input())

for i in range(1, t+1):
    p, q, r, s, w = map(int, input().split())
    A = 0
    B = 0
    if w < r:
        A = p*w
        B = q
    else:
        A = p*w
        B = (w-r)*s + q
    print(f'#{i} {min(A, B)}')