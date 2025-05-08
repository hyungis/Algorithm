import sys
def round(x):
    if x-int(x) >= 0.5:
        return int(x) +1
    else:
        return int(x)

n = int(input())
arr = [int(sys.stdin.readline().strip()) for _ in range(n)]
arr.sort()
avg = round(n*0.15)
result = arr[avg:n-avg]

if len(result) == 0:
    print(0)
else:
    print(round(sum(result)/len(result)))