n = int(input())
num = n
result = 0

while 1:
    x = num//10
    y = num%10
    z = (x+y)%10
    num = y*10+z
    result += 1
    if n == num:
        print(result)
        break