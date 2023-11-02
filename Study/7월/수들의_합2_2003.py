import sys
input = sys.stdin.readline

# [1]
N, M = map(int, input().split())
A = list(map(int, input().split()))
cnt = temp = 0
s, e = 0, 1
while s <= e and e <= N:
    temp = sum(A[s:e])  # 반복문을 돌 때마다 temp를 구하는 게 아니라 포인터 이동할 때 마다 더하고 빼는 작업 -> 시간 단축
    if temp < M:
        e += 1
    elif temp > M:
        s += 1
    else:
        s += 1
        e = s + 1
        cnt += 1
print(cnt)