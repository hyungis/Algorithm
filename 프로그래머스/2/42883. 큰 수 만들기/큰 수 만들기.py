def solution(number, k):
    answer = ''
    
    N = len(number)
    result = [number[0]]
    idx = 0
    
    for i in range(1, N):
        if result[-1] < number[i]:
            while result and result[-1] < number[i] and k:
                result.pop()
                k -= 1
            result.append(number[i])
        else:
            if len(result) < N - k:
                result.append(number[i])
            else:
                continue
    
    answer = ''.join(result)
    
    return answer