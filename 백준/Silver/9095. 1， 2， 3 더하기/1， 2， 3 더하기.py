
def dp(x):
    if x == 1:
        return 1
    elif x == 2:
        return 2
    elif x == 3:
        return 4
    else:
        return dp(x-1)+dp(x-2)+dp(x-3)


t = int(input())
for tc in range(t):
    n = int(input())
    print(dp(n))