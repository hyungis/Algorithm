num_list = set(range(1, 10001))
x_list = set()

for i in num_list:
    for j in str(i):
        i += int(j)
    x_list.add(i)

result = num_list-x_list
for i in sorted(result):
    print(i)