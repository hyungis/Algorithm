def solution(s):
    li = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
    
    for i in li:
        s = s.replace(i,  str(li.index(i)))
    return int(s)