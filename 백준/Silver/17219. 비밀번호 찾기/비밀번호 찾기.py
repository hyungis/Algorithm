n, m = map(int, input().split())

arr = {}
for _ in range(n):
    site, pw = input().split()
    arr[site] = pw
result = []
for i in range(m):
    x = input()
    result.append(arr[x])

for i in result:
    print(i)