import sys
import heapq
input = sys.stdin.readline

def dijkstra(adjM, D, X):
    visited = [0] * (N + 1)

    heap = []
    D[X] = 0
    heapq.heappush(heap, (D[X], X))

    while heap:
        d, v = heapq.heappop(heap)

        if visited[v]:continue
        visited[v] = 1

        for w in range(1, N+1):
            if adjM[v][w] and D[w] > d + adjM[v][w]:
                D[w] = d + adjM[v][w]
                heapq.heappush(heap, (D[w], w))


N, M, X = map(int, input().split())
adjM = [[0] * (N+1) for _ in range(N+1)]
rev_adjM = [[0] * (N+1) for _ in range(N+1)]

for _ in range(M):
    s, e, d = map(int, input().split())
    adjM[s][e] = d
    rev_adjM[e][s] = d

INF = 987654321
rlt = [0] + [INF] * N
rev_rlt = [0] + [INF] * N

dijkstra(adjM, rlt, X)
dijkstra(rev_adjM, rev_rlt, X)

for i in range(1, N+1):
    rlt[i] += rev_rlt[i]

print(max(rlt))