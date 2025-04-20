def solution(arr, intervals):
    answer = []
    for i, j in intervals:
        for k in range(i, j+1):
            answer.append(arr[k])
    return answer