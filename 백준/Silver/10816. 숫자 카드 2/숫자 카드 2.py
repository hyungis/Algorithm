import sys
n = int(sys.stdin.readline().strip())
arr1 = list(map(int, sys.stdin.readline().strip().split()))
m = int(sys.stdin.readline().strip())
arr2 = list(map(int, sys.stdin.readline().strip().split()))
arr1.sort()

count = {}
for i in arr1:
    if i in count:
        count[i] += 1
    else:
        count[i] = 1
def binary_search(m, arr1, start, end):
    if start > end:
        return 0
    mid = (start+end) // 2
    if m == arr1[mid]:
        return count[m]
    elif m > arr1[mid]:
        return binary_search(m, arr1, mid+1, end)
    else:
        return binary_search(m, arr1, start, mid-1)

for m in arr2:
    print(binary_search(m, arr1, 0, len(arr1)-1), end=' ')