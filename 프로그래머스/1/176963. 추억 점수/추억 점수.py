def solution(name, yearning, photo):
    answer = []
    dict = {}
    for i in range(len(name)):
        dict[name[i]] = yearning[i]
    
    for i in photo:
        result = 0
        for j in i:
            if j in name:
                result += dict[j]
        answer.append(result)
    return answer