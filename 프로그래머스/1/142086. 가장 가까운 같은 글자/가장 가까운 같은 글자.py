def solution(s):
    dict = {}
    answer = []
    for i in range(len(s)):
        if s[i] not in dict:
            dict[s[i]] = i
            answer.append(-1)
        else:
            answer.append(i-dict[s[i]])
            dict[s[i]] = i
    return answer