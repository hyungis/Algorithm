import math
def solution(progresses, speeds):
    answer = []
    arr = []
    cnt = 1
    for i in range(len(progresses)):
        arr.append(math.ceil((100-progresses[i])/speeds[i]))
    
    max_num = arr[0]
    for i in range(1, len(arr)):
        if arr[i] <= max_num:
            cnt += 1
        else:
            answer.append(cnt)
            max_num = arr[i]
            cnt = 1
    answer.append(cnt)
        
    return answer