from itertools import combinations
def solution(number):
    answer = list(combinations(number, 3))
    result = 0
    for i in answer:
        if sum(i) == 0:
            result += 1
    return result