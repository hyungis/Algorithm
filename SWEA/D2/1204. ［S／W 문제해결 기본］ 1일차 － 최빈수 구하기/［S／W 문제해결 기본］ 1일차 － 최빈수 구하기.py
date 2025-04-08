T = int(input())
for i in range(1, T+1):
    _ = input()
    grades = list(map(int, input().split()))
    freq = [0] * 101 # 점수는 0 ~ 100점까지 있으니까
    mode = 0 # 최빈값
    for grade in grades:
        freq[grade] += 1 # 현재점수의 빈도상승
        if freq[grade] >= freq[mode]:
        	mode = grade
    print(f"#{i} {mode}")