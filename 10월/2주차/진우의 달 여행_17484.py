import sys
input = sys.stdin.readline


def dfs(k, csum, d, cj):
    global _min

    if _min < csum:
        return

    if k == N:
        _min = min(csum, _min)
    else:
        for dj in ([-1, 0, 1]):
            nj = cj + dj
            if 0 <= nj < M  and dj != d:
                dfs(k+1, csum + space[k][nj], dj, nj)


N, M = map(int, input().split())
space = [list(map(int, input().split())) for _ in range(N)]
_min = 987654321
for i in range(M):
    dfs(0, 0, -3, i)
print(_min)