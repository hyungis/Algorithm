def solution(s):
    arr = []
    for i in s:
        if i == '(':
            arr.append(i)
        else:
            if len(arr)>0 and arr[-1] == '(':
                arr.pop()
            else:
                arr.append(i)
    if arr:
        return False
    else:
        return True
