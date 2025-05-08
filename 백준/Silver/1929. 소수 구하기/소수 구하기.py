def is_prime(n):
    if n == 1:
        return False
    end = int(n**(1/2))
    for i in range(2, end+1):
        if n % i == 0:
            return False
    return True

n, m = map(int, input().split())

for i in range(n, m+1):
    if is_prime(i):
        print(i)