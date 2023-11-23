import sys
input = sys.stdin.readline

# N <= 10
def dfs(s, c, csum):    # s : 출발지, c : 현재 위치, csum : 현재 비용
    global _min

    if _min <= csum:
        return

    if sum(visited) == N:
        if arr[c][s]:
            _min = min(_min, csum + arr[c][s])
        return

    for i in range(N):
        if arr[c][i] != 0 and not visited[i]:
            visited[i] = 1
            dfs(s, i, csum + arr[c][i])
            visited[i] = 0

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
visited = [0] * N
_min = 987654321

for i in range(N):
    visited[i] = 1
    dfs(i, i, 0)
    visited[i] = 0

print(_min)