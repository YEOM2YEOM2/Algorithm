import sys
from collections import deque
input = sys.stdin.readline

def bfs(si, sj):
    q = deque()
    visited = [[0] * N for _ in range(N)]
    q.append((si, sj))
    visited[si][sj] = 1

    while q:
        ci, cj = q.popleft()

        if ci == ei and cj == ej:
            print(visited[ei][ej] - 1)
            break

        for di, dj in ((-1, -2), (-2, -1), (-2, 1), (-1, 2), (1, 2), (2, 1), (2, -1), (1, -2)):
            ni = ci + di
            nj = cj + dj
            if 0 <= ni < N and 0 <= nj < N and not visited[ni][nj]:
                visited[ni][nj] = visited[ci][cj] + 1
                q.append((ni, nj))


T = int(input())
for _ in range(T):
    # N * N 체스판
    N = int(input())
    si, sj = map(int, input().split())
    ei, ej = map(int, input().split())

    bfs(si, sj)