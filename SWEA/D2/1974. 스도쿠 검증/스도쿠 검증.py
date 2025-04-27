t = int(input())

for tc in range(1, t+1):
    arr = [list(map(int, input().split())) for _ in range(9)]
    result = 1
    for i in range(9):
        li = set()
        for j in range(9):
            li.add(arr[i][j])
        if len(li) != 9:
            result = 0
            break
    for i in range(9):
        li = set()
        for j in range(9):
            li.add(arr[j][i])
        if len(li) != 9:
            result = 0
            break
    for i in range(0, 9, 3):
        for j in range(0, 9, 3):
            li = set()
            for x in range(3):
                for y in range(3):
                    li.add(arr[i+x][j+y])
            if len(li) != 9:
                result = 0
                break

    print(f'#{tc} {result}')