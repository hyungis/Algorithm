def solution(sizes):
    w = []
    h = []
    
    for i, j in sizes:
        if i >= j:
            w.append(i)
            h.append(j)
        else:
            w.append(j)
            h.append(i)
    return max(w)*max(h)