from itertools import permutations

n, m = map(int, input().split())
arr = list(range(1, n+1))
result = list(permutations(arr,m))

for i in result:
    print(*i, sep='\n')