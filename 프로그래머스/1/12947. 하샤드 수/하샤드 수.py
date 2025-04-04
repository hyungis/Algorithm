def solution(x):
    li = [int(i) for i in str(x)]
    if x % sum(li) == 0:
        return True
    else:
        return False