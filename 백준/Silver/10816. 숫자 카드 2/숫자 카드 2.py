n = int(input())
arr1 = list(map(int, input().split()))
m = int(input())
arr2 = list(map(int, input().split()))
arr1.sort()

count = {}
for i in arr1:
    if i in count:
        count[i] += 1
    else:
        count[i] = 1

for i in arr2:
    start, end = 0, n-1

    while start <= end:
        mid = (start+end) // 2
        if i == arr1[mid]:
            print(count[i], end=' ')
            break
        elif i > arr1[mid]:
            start = mid + 1
        else:
            end = mid - 1
    else:
        print(0, end= ' ')
