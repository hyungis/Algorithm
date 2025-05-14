month = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
day = {1: 'MON', 2: 'TUE', 3: 'WED', 4: 'THU', 5:'FRI', 6:'SAT', 0:'SUN'}

m, d = map(int, input().split())

if m == 1:
    print(day[d % 7])
else:
    result = sum(month[:m-1]) + d
    print(day[result % 7])
