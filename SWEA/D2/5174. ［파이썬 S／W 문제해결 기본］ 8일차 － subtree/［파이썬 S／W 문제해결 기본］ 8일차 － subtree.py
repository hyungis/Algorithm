t = int(input())

def sub_tree(idx):
    global cnt

    for i in range(2):
        if tree[i][idx]:
            cnt += 1
            n = tree[i][idx]
            sub_tree(n)
for tc in range(1, t+1):
    e, n = map(int, input().split())
    li = list(map(int, input().split()))

    tree = [[0]*(e+2)for _ in range(2)]

    for i in range(e):
        idx = li[i*2]
        number = li[i*2+1]
        if tree[0][idx] == 0:
            tree[0][idx] = number
        else:
            tree[1][idx] = number
    cnt = 1
    sub_tree(n)
    print(f'#{tc} {cnt}')