t = int(input())
li = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

for tc in range(1, t+1):
    result = 0
    mon, day, mon1, day1 = map(int, input().split())
    if mon == mon1:
        print(f'#{tc} {day1-day+1}')
    else:
        for i in range(mon, mon1-1):
            result += li[i]
        print(f'#{tc} {result+(li[mon-1]-day)+day1+1}')