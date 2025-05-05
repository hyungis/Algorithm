n = int(input())

def factorial(x):
    if x == 0 or x == 1:
        return 1
    else:
        return x*factorial(x-1)

result = str(factorial(n))
cnt = 0

for i in result[::-1]:
    if i == '0':
        cnt += 1
    else:
        break
print(cnt)