n = int(input())

for i in range(1, n+1):
    testcase = int(input())
    li = list(map(int, input().split()))
    arr = [0] * 101
    answer_li = []
    for j in li:
        arr[j] += 1
    
    for k in range(len(arr)):
        if arr[k] == max(arr):
            answer_li.append(k)
    print(f"#{testcase} {max(answer_li)}")