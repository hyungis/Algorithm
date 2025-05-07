n = int(input())

for tc in range(n):
    n = input()
    stack = []

    for i in n:
        if i == '(':
            stack.append(i)
        elif i == ')':
            if stack and stack[-1] == '(':
                stack.pop()
            else:
                stack.append(i)
    if stack:
        print('NO')
    else:
        print('YES')