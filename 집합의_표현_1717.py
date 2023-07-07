from collections import deque
import sys
input = sys.stdin.readline

# [1] 시간 초과
# def bfs(a, b):
#     visited = [0] * (n + 1)
#     q = deque()
#     q.append(a)
#     visited[a] = 1
#
#     while q:
#         t = q.popleft()
#
#         if t == b:
#             return 'YES'
#
#         for w in adjL[t]:
#             if not visited[w]:
#                 q.append(w)
#                 visited[w] = 1
#
#     return 'NO'
#
#
# n, m = map(int, input().split())
# lst = [[i] for i in range(n+1)]
# adjL = [[] for _ in range(n+1)]
# for _ in range(m):
#     c, a, b = map(int, input().split())
#     if not c:   # 합집합 연산
#         if a == b:
#             adjL[a].append(b)
#         else:
#             adjL[a].append(b)
#             adjL[b].append(a)
#     else:   # 같은 집합에 포함되어 있는지 판단
#         print(bfs(a, b))

# [2] union
