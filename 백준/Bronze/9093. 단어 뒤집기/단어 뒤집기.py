n = int(input())

for _ in range(n):
    arr = input().split()
    result = []
    for i in arr:
        result.append(i[::-1])

    print(' '.join(result))