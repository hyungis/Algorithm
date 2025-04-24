t = int(input())

for tc in range(1, t+1):
    s = input()
    li = []
    for i in range(len(s)):
        if len(li) == 0:
            li.append(s[i])
        else:
            if li[-1] == s[i]:
                li.pop()
            else:
                li.append(s[i])
    print(f'#{tc} {len(li)}')