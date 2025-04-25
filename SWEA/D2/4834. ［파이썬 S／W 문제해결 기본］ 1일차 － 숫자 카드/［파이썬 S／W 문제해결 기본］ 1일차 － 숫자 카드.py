t = int(input())

for tc in range(1, t+1):
    n = int(input())
    a = input()
    dic = {x:0 for x in a}

    for i in a:
        dic[i] += 1
    max_key = []
    max_value = max(dic.values())
    for key, value in dic.items():
        if value == max_value:
            max_key.append(key)
    print(f'#{tc} {max(max_key)} {max_value}')