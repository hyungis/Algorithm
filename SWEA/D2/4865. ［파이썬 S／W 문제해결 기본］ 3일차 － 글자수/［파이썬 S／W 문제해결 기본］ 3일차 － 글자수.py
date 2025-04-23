t = int(input())

for testcase in range(1, t+1):
    n = input()
    m = input()
    dict = {x:0 for x in n}
    for i in m:
        if i in dict:
            dict[i] += 1
    print(f'#{testcase} {max(dict.values())}')