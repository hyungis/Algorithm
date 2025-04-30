t = int(input())

for tc in range(1, t+1):
    n = int(input())
    score = [0]*101
    result = 0
    arr = list(map(int, input().split()))
    for i in arr:
        score[i] += 1
    max_score = max(score)
    for i in range(100, 0, -1):
        if score[i] == max_score:
            result = i
            break
    print(f'#{tc} {result}')