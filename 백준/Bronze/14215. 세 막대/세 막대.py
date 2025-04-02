li = list(map(int, input().split()))
li.sort()

if li[0]+li[1] > li[2]:
    print(sum(li))
else:
    print(li[0]+li[1]+(li[0]+li[1]-1))