import sys
def binary_search(target, data):
    start, end = 0, n-1
    while start <= end:
        mid = (start+end)//2
        if data[mid] == target:
            return dic[data[mid]]
            break
        elif data[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    else:
        return 0
n = int(sys.stdin.readline())
arr_1 = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
arr_2 = list(map(int, sys.stdin.readline().split()))
arr_1.sort()

dic = {}
for i in arr_1:
    if i not in dic:
        dic[i] = 1
    else:
        dic[i] += 1

for j in arr_2:
    print(binary_search(j, arr_1), end=' ')