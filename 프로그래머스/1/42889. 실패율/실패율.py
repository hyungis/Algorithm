def solution(N, stages):
    dict = {}
    player = len(stages)
    for i in range(1, N+1):
        if player == 0:
            dict[i] = 0
        else:
            dict[i] = stages.count(i)/player
            player -= stages.count(i)
    
    answer = sorted(dict, key = lambda x: dict[x], reverse=True)
    
    return answer