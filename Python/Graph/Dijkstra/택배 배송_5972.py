import heapq
import sys
input = sys.stdin.readline

# 인접 행렬 메모리 초과
# 인접 리스트 통과, 236ms
def dijkstra(s):
    heap = []
    D[s] = 0
    heapq.heappush(heap, (D[s], s))

    while heap:
        dump, v = heapq.heappop(heap)

        if visited[v]: continue
        visited[v] = 1

        for w, d in adjL[v]:
            if D[w] > D[v] + d:
                D[w] = D[v] + d
                heapq.heappush(heap, (D[w], w))

N, M = map(int, input().split())
visited = [0] * (N+1)
INF = 987654321
D = [INF] * (N+1)
adjL = [[] for _ in range(N+1)]

for _ in range(M):
    s, e, d = map(int, input().split())
    adjL[s].append((e, d))
    adjL[e].append((s, d))

dijkstra(1)
print(D[N])