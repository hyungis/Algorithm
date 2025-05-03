n = list(map(int, input().split()))
answer = 0
for i in range(len(n)):
    answer += n[i]**2

answer = answer%10

print(answer)