def solution(d, budget):
    answer = 0
    s = 0
    d.sort()
    for i in d:
        answer += 1
        s += i
        if s > budget:
            return answer - 1
    return answer