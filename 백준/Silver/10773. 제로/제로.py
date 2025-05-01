n = int(input())

stack = []

for i in range(n):
    x = int(input())
    if x != 0:
        stack.append(x)
    else:
        stack.pop()
print(sum(stack))