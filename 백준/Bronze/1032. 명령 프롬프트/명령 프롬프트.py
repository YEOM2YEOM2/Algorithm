N = int(input())
ans = list(input())
for _ in range(N-1):
    temp = list(input())
    for i in range(len(ans)):
        if ans[i] != temp[i]:
            ans[i] = '?'

for i in range(len(ans)):
    print(ans[i], end="")