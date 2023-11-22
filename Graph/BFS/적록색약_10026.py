from collections import deque
import sys
input = sys.stdin.readline

# 적록색약인 사람이 보는 경우 추가
def bfs(i, j, color, flag):
    q = deque()
    q.append((i, j))
    if flag == 1:
        visited[i][j] = 1

        while q:
            ci, cj = q.popleft()

            for di, dj in ((-1, 0), (0, 1), (1, 0), (0, -1)):
                ni = ci + di
                nj = cj + dj
                if 0 <= ni < N and 0 <= nj < N and not visited[ni][nj] and arr[ni][nj] == color:
                    visited[ni][nj] = visited[ci][cj] + 1
                    q.append((ni, nj))
    else:
        _visited[i][j] = 1

        if color == "B":
            while q:
                ci, cj = q.popleft()

                for di, dj in ((-1, 0), (0, 1), (1, 0), (0, -1)):
                    ni = ci + di
                    nj = cj + dj
                    if 0 <= ni < N and 0 <= nj < N and not _visited[ni][nj] and arr[ni][nj] == "B":
                        _visited[ni][nj] = _visited[ci][cj] + 1
                        q.append((ni, nj))
        else:
            while q:
                ci, cj = q.popleft()

                for di, dj in ((-1, 0), (0, 1), (1, 0), (0, -1)):
                    ni = ci + di
                    nj = cj + dj
                    if 0 <= ni < N and 0 <= nj < N and not _visited[ni][nj] and arr[ni][nj] != "B":
                        _visited[ni][nj] = _visited[ci][cj] + 1
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
            bfs(i, j, arr[i][j], 1)
        if not _visited[i][j]:
            _cnt += 1
            bfs(i, j, arr[i][j], 2)

print(cnt, _cnt, end=" ")