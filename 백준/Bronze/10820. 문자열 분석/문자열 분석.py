while True:
    try:
        n = input()
        result = [0,0,0,0]
        arr = list(n)
        for i in arr:
            if i.islower():
                result[0] += 1
            elif i.isupper():
                result[1] += 1
            elif i.isnumeric():
                result[2] += 1
            else:
                result[3] += 1
        print(' '.join(map(str, result)))
    except EOFError:
        break