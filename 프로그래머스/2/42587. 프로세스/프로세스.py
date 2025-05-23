from collections import deque
def solution(priorities, location):
    answer = 0
    p_arr = deque(priorities)
    name_arr = deque(range(len(priorities)))
    
    while True:
        x = p_arr.popleft()
        idx = name_arr.popleft()
        if p_arr and x < max(p_arr):
            p_arr.append(x)
            name_arr.append(idx)
        else:
            answer += 1
            if idx == location:
                break
    
    return answer