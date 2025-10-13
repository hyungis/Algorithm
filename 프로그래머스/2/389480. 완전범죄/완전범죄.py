def solution(info, n, m):
    global answer
    
    answer = n
    visited = set()
    def dfs(depth, N, M):
        global answer
        
        visited.add((depth, N, M))
        if N >= n or M >= m: return
        if N >= answer: return 
        if depth == len(info) and N < answer:
            answer = N
            return
        
        if (depth + 1, N, M + info[depth][1]) not in visited:
            dfs(depth + 1, N, M + info[depth][1])
        if (depth + 1, N + info[depth][0], M) not in visited:
            dfs(depth + 1, N + info[depth][0], M)
        
    
    dfs(0, 0, 0)
    
    return answer if answer != n else -1