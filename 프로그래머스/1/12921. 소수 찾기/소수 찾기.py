def solution(n):
    prime = [True for _ in range(n+1)]
    answer = 0
    for i in range(2, int(n**0.5)+1):
        j = 2
        if prime[i] == True:
            while i*j <= n:
                prime[i*j] = False
                j += 1
    
    for i in range(2, n+1):
        if prime[i]:
            answer += 1
    return answer