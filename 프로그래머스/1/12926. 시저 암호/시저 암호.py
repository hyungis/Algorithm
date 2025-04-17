def solution(s, n):
    lower_num = 'abcdefghijklmnopqrstuvwxyz'
    upper_num = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    li = []
    
    for i in s:
        if i == " ":
            li.append(" ")
        elif i.islower():
            a = lower_num.find(i) + n
            li.append(lower_num[a%26])
        else:
            b = upper_num.find(i) + n
            li.append(upper_num[b%26])
    return ''.join(li)