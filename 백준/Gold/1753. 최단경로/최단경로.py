import heapq
import sys
input = sys.stdin.readline

def dijkstra(s):
    visited = [0] * (V+1)
    heap = []
    D[s] = 0
    heapq.heappush(heap, (D[s], s))

    while heap:
        d, v = heapq.heappop(heap)

        if visited[v]: continue
        visited[v] = 1

        for w in range(len(adjL[v])):
            if D[adjL[v][w][0]] > d + adjL[v][w][1]:
                D[adjL[v][w][0]] = d + adjL[v][w][1]
                heapq.heappush(heap, (D[adjL[v][w][0]], adjL[v][w][0]))


V, E = map(int, input().split())
K = int(input())
adjL = [[] for _ in range(V+1)]
for _ in range(E):
    u, v, w = map(int, input().split())
    adjL[u].append([v, w])

INF = 987654321
D = [INF] * (V+1)
dijkstra(K)

for i in range(1, V+1):
    if D[i] == INF:
        print('INF')
    else:
        print(D[i])