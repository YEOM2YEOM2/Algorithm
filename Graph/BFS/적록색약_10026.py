from collections import deque
import sys
input = sys.stdin.readline

# 적록색약인 사람이 보는 경우 추가
def bfs(i, j, color):
    q = deque()
    q.append((i, j))
    visited[i][j] = 1

    while q:
        ci, cj = q.popleft()

        for di, dj in ((-1, 0), (0, 1), (1, 0), (0, -1)):
            ni = ci + di
            nj = cj + dj
            if 0 <= ni < N and 0 <= nj < N and not visited[ni][nj] and arr[ni][nj] == color:
                visited[ni][nj] = visited[ci][cj] + 1
                q.append((ni, nj))

N = int(input())
arr = [list(input().strip()) for _ in range(N)]
visited = [[0] * N for _ in range(N)]
_visited = [[0] * N for _ in range(N)]
cnt, _cnt = 0, 0

for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            cnt += 1
            bfs(i, j, arr[i][j])

print(cnt, _cnt, end=" ")