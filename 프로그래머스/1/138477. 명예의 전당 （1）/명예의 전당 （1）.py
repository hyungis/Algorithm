def solution(k, score):
    answer = []
    result = []
    
    for i in score:
        answer.append(i)
        if len(answer) > k:
            answer.remove(min(answer))
        result.append(min(answer))
    return result