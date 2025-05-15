a, b = map(int, input().split())

result = [0]
answer = 0
for i in range(1, b+1):
    for j in range(i):
        result.append(i)

for i in range(a, b+1):
    answer += result[i]
print(answer)