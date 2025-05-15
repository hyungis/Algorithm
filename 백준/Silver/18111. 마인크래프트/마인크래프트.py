import sys
n, m, b = map(int, sys.stdin.readline().split())

block = []
for _ in range(n):
    block.append(list(map(int, sys.stdin.readline().split())))

answer = float('inf')
target = 0

for i in range(257):
    take_block = 0
    use_block = 0
    for x in range(n):
        for y in range(m):
            if block[x][y] > i:
                take_block += block[x][y] - i
            else:
                use_block += i - block[x][y]
    if use_block > take_block + b:
        continue
    cnt = take_block*2 + use_block
    if cnt <= answer:
        answer = cnt
        target = i
print(answer, target)