arr = [0]*10
n = [int(input()) for _ in range(3)]
result = 1
for i in n:
    result = result*i

for i in str(result):
    arr[int(i)] += 1

for i in arr:
    print(i)