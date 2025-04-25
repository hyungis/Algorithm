t = int(input())

for tc in range(1, t+1):
    n = input()
    for i in range(1, 15):
        if n[:i]*(30//i) in n:
            print(f'#{tc} {i}')
            break