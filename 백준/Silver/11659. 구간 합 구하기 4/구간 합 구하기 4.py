import sys

n, m = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
prefix_sum = [0]*(n+1)
prefix_sum[1] = arr[0]

for i in range(2, n+1):
    prefix_sum[i] = prefix_sum[i-1] + arr[i-1]
for j in range(m):
    a, b = map(int, sys.stdin.readline().split())
    print(prefix_sum[b]-prefix_sum[a-1])
