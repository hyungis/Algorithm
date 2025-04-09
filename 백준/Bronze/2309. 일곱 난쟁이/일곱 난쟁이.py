n = [int(input()) for _ in range(9)]

sums = sum(n)
for i in range(8):
    for j in range(i+1, 9):
        if sums - (n[i]+n[j]) == 100:
            a = n[i]
            b = n[j]

n.remove(a)
n.remove(b)
n.sort()
for i in n:
    print(i)