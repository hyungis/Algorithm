def sosu(n):
    if n < 2:
        return False
    for i in range(2, int(n**(1/2))+1):
        if n%i == 0:
            return False
    return True
from itertools import permutations
def solution(numbers):
    answer = 0
    arr = []
    result = []
    for i in range(1, len(numbers)+1):
        arr.extend(permutations(numbers, i))
    for i in arr:
        result.append(int(''.join(i)))
    result = list(set(result))
    
    for i in result:
        if sosu(i):
            answer += 1
    return answer