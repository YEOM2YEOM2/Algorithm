import sys
input = sys.stdin.readline

# [1] 시간 초과
def pos(order, house):
    D = [987654321] * len(house)
    for i in range(len(house)):
        for k in range(M):
            temp = abs(order[k][0] - house[i][0]) + abs(order[k][1] - house[i][1])
            if D[i] > temp:
                D[i] = temp
    return sum(D)

def dfs(s, k):
    global _min
    if k == M:
        _min = min(_min, pos(order, house))
        return

    for i in range(s, len(store)):
        if not visited[i]:
            visited[i] = 1
            order[k] = store[i]
            dfs(i+1, k+1)
            visited[i] = 0

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
_min = 987654321
house = []
store = []
# 치킨가게, 집 찾기
for i in range(N):
    for j in range(N):
        if arr[i][j] == 1:
            house.append([i, j])
        elif arr[i][j] == 2:
            store.append([i, j])
# 치킨집 방문 표시
visited = [0] * len(store)
order = [0] * M
dfs(0, 0)
print(_min)