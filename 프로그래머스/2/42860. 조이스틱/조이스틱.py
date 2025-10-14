def solution(name):
    answer = 0
    
    count = 0
    l = len(name)
    mn = 21
    for i in range(l):
        up = ord(name[i]) - ord('A')
        down = ord('Z') - ord(name[i]) + 1
        if name[i] != 'A':
            count += min(up, down)
        
        nxt = i + 1
        while nxt < l and name[nxt] == 'A':
            nxt += 1
        
        mn = min(mn, 2 * i + l - nxt, i + 2 * (l - nxt))
    
    answer += count + mn
    return answer