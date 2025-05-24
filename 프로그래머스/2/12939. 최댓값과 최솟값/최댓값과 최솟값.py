def solution(s):
    x = list(map(int, s.split()))
    max_num = max(x)
    min_num = min(x)
    answer = ''
    answer += str(min_num)+' '+str(max_num)
    return answer