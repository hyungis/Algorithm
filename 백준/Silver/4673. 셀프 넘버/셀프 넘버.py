arr = set(range(1,10001))
x_list = set()
for i in arr:
    for j in str(i):
        i += int(j)
    x_list.add(i)
result = arr - x_list
for i in sorted(result):
    print(i)