from itertools import combinations
n, k = map(int, input().split())

arr = [x for x in range(1, n+1)]
answer = len(list(combinations(arr, k)))
print(answer)