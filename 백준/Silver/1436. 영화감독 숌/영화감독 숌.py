n = int(input())
nph = 666
cnt = 0
while True:
    if '666' in str(nph):
        cnt += 1
    if cnt == n:
        print(nph)
        break
    nph += 1