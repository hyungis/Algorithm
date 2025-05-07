while True:
    n = input()
    if n == '.':
        break
    stack = []
    for i in n:
        if i in ['(', '[']:
            stack.append(i)
        elif i == ')':
            if stack and stack[-1] == '(':
                stack.pop()
            else:
                stack.append(i)
        elif i == ']':
            if stack and stack[-1] == '[':
                stack.pop()
            else:
                stack.append(i)
        if i == '.':
            break
    if len(stack) == 0:
        print('yes')
    else:
        print('no')