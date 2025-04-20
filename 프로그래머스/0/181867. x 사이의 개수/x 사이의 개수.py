def solution(myString):
    answer = []
    result = myString.split('x')
    for i in result:
        answer.append(len(i))
    return answer