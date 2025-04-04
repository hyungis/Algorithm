def solution(numbers):
    answer = 0
    li = '0123456789'
    for i in li:
        if int(i) not in numbers:
            answer += int(i)
    return answer