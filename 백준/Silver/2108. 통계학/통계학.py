import sys
input = sys.stdin.readline

n = int(input())
arr = [int(input()) for _ in range(n)]
arr.sort()
print(round(sum(arr)/n))
print(arr[n//2])
dict = {}
for i in arr:
    if i not in dict:
        dict[i] = 1
    else:
        dict[i] += 1
max_num = max(dict.values())
max_arr = []

for i in dict:
    if dict[i] == max_num:
        max_arr.append(i)
if len(max_arr) > 1:
    print(max_arr[1])
else:
    print(max_arr[0])

print(max(arr)-min(arr))