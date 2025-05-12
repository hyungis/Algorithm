import sys
t = int(input())

for tc in range(t):
    n = int(input())
    dic = {}
    cnt = 1
    for i in range(n):
        name, type = sys.stdin.readline().strip().split()
        if type in dic:
            dic[type].append(name)
        else:
            dic[type] = [name]

    for x in dic:
        cnt *= (len(dic[x])+1)

    print(cnt-1)