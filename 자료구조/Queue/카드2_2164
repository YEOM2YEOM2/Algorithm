from collections import deque
import sys
input = sys.stdin.readline

N = int(input())
ans = deque()
for i in range(1, N+1):
    ans.append(i)

for _ in range(N-1):
    ans.popleft()
    temp = ans.popleft()
    ans.append(temp)

print(*ans)
