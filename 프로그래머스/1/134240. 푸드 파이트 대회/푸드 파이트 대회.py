def solution(food):
    answer = []
    for i in range(len(food)):
        if food[i] == 1:
            continue
        else:
            for j in range(food[i]//2):
                answer.append(str(i))
    r_answer = answer[::-1]
    answer.append(str(0))
    answer += r_answer
    
    return ''.join(answer)