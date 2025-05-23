import sys
n = int(sys.stdin.readline())
a = list(map(int, sys.stdin.readline().split()))
b, c = map(int, sys.stdin.readline().split())
answer = 0
for i in range(len(a)):
    a[i] = a[i] - b
    answer += 1
    if a[i] > 0:
        if a[i] % c:
            answer += a[i]//c + 1
        else:
            answer += a[i]//c


print(answer)