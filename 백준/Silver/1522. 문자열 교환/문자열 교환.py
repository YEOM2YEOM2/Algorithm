import sys
input = sys.stdin.readline

# 슬라이딩 윈도우, 브루트포스
word = list(input().strip())

a_total = 0
for i in range(len(word)):
    if word[i] == 'a':
        a_total += 1

ans = 987654321

for i in range(len(word)):
    if i + a_total < len(word):
        temp = word[i:i+a_total]
    else:
        temp = word[i:len(word)] + word[0:a_total-(len(word)-i)]

    tmp = 0
    for t in temp:
        if t == "b":
            tmp += 1

    ans = min(ans, tmp)

print(ans)