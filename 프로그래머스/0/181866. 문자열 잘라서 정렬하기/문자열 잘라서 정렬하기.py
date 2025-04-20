def solution(myString):
    answer = []
    myString = myString.split('x')
    for i in myString:
        if not i == '':
            answer.append(i)
    return sorted(answer)