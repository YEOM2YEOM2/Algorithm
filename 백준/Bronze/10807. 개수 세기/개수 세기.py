N = int(input())
lst = list(map(int, input().split()))
M = int(input())
cnt = 0;
for i in range(N):
    if M == lst[i]:
        cnt += 1;
print(cnt)