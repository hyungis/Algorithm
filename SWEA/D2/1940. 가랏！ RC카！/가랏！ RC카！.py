t = int(input())

for tc in range(1, t+1):
    n = int(input())
    speed = 0
    result = 0
    for i in range(n):
        li = list(map(int, input().split()))
        if li[0] == 1:
            speed += li[1]
            result += speed
        elif li[0] == 2:
            if speed < li[1]:
                speed = 0

            else:
                speed -= li[1]
                result += speed
        else:
            result += speed
    print(f'#{tc} {result}')