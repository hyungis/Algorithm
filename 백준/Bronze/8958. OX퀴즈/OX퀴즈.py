t = int(input())

for _ in range(t):
    ox = input()
    n = 0
    result = 0
    for i in ox:
        if i == 'X':
            n = 0
        else:
            n += 1
            result += n
    print(result)