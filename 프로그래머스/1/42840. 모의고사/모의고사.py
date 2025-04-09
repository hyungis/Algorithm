def solution(answers):
    p1 = [1,2,3,4,5]
    p2 = [2,1,2,3,2,4,2,5]
    p3 = [3,3,1,1,2,2,4,4,5,5]
    answer = [0,0,0]
    result = []
    
    for i, j in enumerate(answers):
        if j == p1[i%len(p1)]:
            answer[0] += 1
        if j == p2[i%len(p2)]:
            answer[1] += 1
        if j == p3[i%len(p3)]:
            answer[2] += 1
    
    for i in range(len(answer)):
        if answer[i] == max(answer):
            result.append(i+1)
    return result