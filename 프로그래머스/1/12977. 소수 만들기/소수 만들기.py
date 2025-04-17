def solution(nums):
    from itertools import combinations
    answer = 0
    li = list(combinations(nums,3))
    for i in li:
        s = sum(i)
        ch = True
        for j in range(2, int(s**0.5)+1):
            if s % j == 0:
                ch = False
                break
        if ch == True:
            answer += 1
    return answer