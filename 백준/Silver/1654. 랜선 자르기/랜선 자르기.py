k, n = map(int, input().split())
arr = [int(input()) for _ in range(k)]

max_lines = max(arr)
start, end = 1, max_lines

while start <= end:
    mid = (start+end) // 2
    result = 0

    for line in arr:
        result += line // mid

    if result >= n:
        start = mid + 1
    else:
        end = mid - 1
print(end)