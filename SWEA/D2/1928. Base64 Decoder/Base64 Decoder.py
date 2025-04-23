t = int(input())

base64_num = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/'

for tc in range(1, t+1):
    n = input()
    tmp = ''
    for i in n:
        num = base64_num.index(i)

        bin_num = bin(num)[2:]
        tmp += bin_num.zfill(6)
    result = ''
    for j in range(0, len(tmp), 8):
        result += chr(int(tmp[j:j+8], 2))
    print(f'#{tc} {result}')