def solution(lottos, win_nums):
    dic = {0:6, 1: 6, 2: 5, 3:4, 4:3, 5:2, 6:1}
    answer = []
    zero_count = lottos.count(0)
    result = 0
    for i in lottos:
        if i in win_nums:
            result += 1
        
    return [dic[result+zero_count], dic[result]]