t = int(input())

for tc in range(1, t+1):
    n = int(input())
    s = ""
    for i in range(n):
        ci, ki = input().split()
        s += ci*int(ki)
    print(f'#{tc}')
    for i in range(len(s)//10+1):
        print(s[:10])
        s = s[10:]