t = int(input())

for _ in range(t):
    n = int(input())
    cnt_0 = [1, 0]
    cnt_1 = [0, 1]
    if n > 1:
        for i in range(n-1):
            cnt_0.append(cnt_1[-1])
            cnt_1.append(cnt_1[-1]+cnt_0[-2])
    print(cnt_0[n], cnt_1[n])