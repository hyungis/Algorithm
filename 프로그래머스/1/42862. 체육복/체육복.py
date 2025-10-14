def solution(n, lost, reserve):
    answer = 0
    
    students = [1 for _ in range(n + 1)]
    for l in lost:
        students[l] = 0
    for r in reserve:
        students[r] += 1
        
    for i in range(1, n + 1):
        if students[i] == 0:
            if students[i - 1] == 2:
                students[i - 1] -= 1
                students[i] += 1
                continue
            elif i != n and students[i + 1] == 2:
                students[i + 1] -= 1
                students[i] += 1
                continue
        else:
            continue
    
    for i in range(1, n + 1):
        if students[i]: answer += 1
    
    return answer