# 이분 탐색, 100000 * 100000
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
lank = []
for _ in range(N):
    temp, num = input().split()
    num = int(num)
    lank.append([temp, num])

for _ in range(M):
    temp = int(input())
    s, e = 0, N
    m = (s+e) // 2
    while s <= e:
        if temp <= lank[m][1]:
            e = m - 1
        elif temp > lank[m][1]:
            s = m + 1
        m = (s + e) // 2
    print(lank[s][0])  # 출력할 수 있는 칭호가 여러 개인 경우 가장 먼저 입력된 칭호 하나만 출력하기 떄문에 lank[s][0] 출력