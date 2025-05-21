n, m = map(int, input().split())

arr_1 = [input() for _ in range(n)]
arr_2 = [input() for _ in range(m)]

result = set(arr_1) & set(arr_2)

print(len(result))
for i in sorted((result)):
    print(i)