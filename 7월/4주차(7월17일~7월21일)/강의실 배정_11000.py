import heapq
import sys
input = sys.stdin.readline

N = int(input())
temp = [list(map(int, input().split())) for _ in range(N)]
temp.sort(key=lambda x: x[0])

room = [temp[0][1]]
for i in range(1, N):
    if room[0] <= temp[i][0]:
        heapq.heappop(room)
    heapq.heappush(room, temp[i][1])
print(len(room))