def solution(s):
    answer = 0
    a, b = 0, 0
    for i in range(len(s)):
        if a == b:
            answer += 1
            x = s[i]
            a, b = 0, 0
        if s[i] == x:
            a += 1
        else:
            b += 1
    return answer