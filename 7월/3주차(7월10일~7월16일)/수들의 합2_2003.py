import sys
input = sys.stdin.readline

# [1] 단순 이중 for문 시간초과, 1 <= N <= 10,000
N, M = map(int, input().split())
A = list(map(int, input().split()))
cnt = temp = 0
s, e = 0, 1
while s <= e and e <= N:
    temp = sum(A[s:e])
    if temp < M:
        e += 1
    elif temp > M:
        s += 1
    else:
        s += 1
        e = s + 1
        cnt += 1
print(cnt)