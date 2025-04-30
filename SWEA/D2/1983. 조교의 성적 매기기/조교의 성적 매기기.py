t = int(input())

for tc in range(1, t+1):
    n, k = map(int, input().split())
    arr_score = ['A+', 'A0', 'A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D0']
    arr = []
    for i in range(n):
        x, y, z = map(int, input().split())
        arr.append((x*0.35)+(y*0.45)+(z*0.2))

    target = arr[k-1]
    arr.sort(reverse=True)
    rate = n//10
    rate_score = arr.index(target) // rate
    print(f'#{tc} {arr_score[rate_score]}')