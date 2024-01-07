from collections import deque
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = [list(map(int, input().strip().split())) for _ in range(N)]
cnt, _max, visited = 0, 0, [[0] * M for _ in range(N)]
for i in range(N):
    for j in range(M):
        if not visited[i][j] and arr[i][j] == 1:
            cnt += 1
            q = deque()
            q.append((i, j))
            visited[i][j] = 1

            temp = 1
            while q:
                ci, cj = q.popleft()

                for di, dj in ((-1, 0), (0, 1), (1, 0), (0, -1)):
                    ni = ci + di
                    nj = cj + dj
                    if 0 <= ni < N and 0 <= nj < M and arr[ni][nj] and not visited[ni][nj]:
                        visited[ni][nj] = visited[ci][cj] + 1
                        q.append((ni, nj))
                        temp += 1

            _max = max(_max, temp)

print(cnt)
print(_max)