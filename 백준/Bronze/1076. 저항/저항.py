color = ['black', 'brown', 'red', 'orange', 'yellow', 'green', 'blue', 'violet', 'grey', 'white']
result = ''
for i in range(2):
    n = input()
    result += str(color.index(n))

n = input()
result += '0'*(color.index(n))
print(int(result))