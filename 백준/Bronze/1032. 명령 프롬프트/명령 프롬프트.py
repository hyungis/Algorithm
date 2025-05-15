n = int(input())

first_num = list(input())

for i in range(n-1):
    x = list(input())
    for j in range(len(first_num)):
        if first_num[j] == x[j]:
            continue
        else:
            first_num[j] = '?'
print(''.join(first_num))

