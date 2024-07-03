word = input()
ans = 0
for _ in range(int(input())):
    temp = input()
    if word[:5] == temp[:5]:
        ans += 1
print(ans)