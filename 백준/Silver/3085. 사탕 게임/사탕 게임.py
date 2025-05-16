def check(arr):
    max_cnt = 1
    for i in range(n):
        cnt = 1
        for j in range(1, n):
            if arr[i][j] == arr[i][j-1]:
                cnt += 1
            else:
                cnt = 1
            max_cnt = max(max_cnt, cnt)

        cnt = 1
        for j in range(1, n):
            if arr[j][i] == arr[j-1][i]:
                cnt += 1
            else:
                cnt = 1
            max_cnt = max(max_cnt, cnt)
            
    return max_cnt


n = int(input())
arr = [list(input()) for _ in range(n)]
answer = 0

for i in range(n):
    for j in range(n):
        if j + 1 < n: # 행 검사
            arr[i][j], arr[i][j+1] = arr[i][j+1], arr[i][j]
            cnt = check(arr)
            answer = max(answer, cnt)
            arr[i][j], arr[i][j + 1] = arr[i][j + 1], arr[i][j]
        if i + 1 < n: #열 검사
            arr[i][j], arr[i+1][j] = arr[i+1][j], arr[i][j]
            cnt = check(arr)
            answer = max(answer, cnt)
            arr[i][j], arr[i + 1][j] = arr[i + 1][j], arr[i][j]
print(answer)