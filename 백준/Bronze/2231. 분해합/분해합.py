n = int(input())

for i in range(1, n+1):
    li = list(map(int, str(i)))
    result = sum(li) + i
    if result == n:
        print(i)
        break
    if i == n:
        print(0)