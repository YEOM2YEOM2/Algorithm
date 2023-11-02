from collections import deque
import sys
input = sys.stdin.readline

# O 폭탄

# [1] 내 풀이 (4192ms)

# R, C, N = map(int, input().split())
# arr = [list(input().strip()) for _ in range(R)]
# q = deque()
#
# for i in range(R):
#     for j in range(C):
#         if arr[i][j] == ".":
#             arr[i][j] = -1
#         else:
#             arr[i][j] = 1
#
# time = 1
# while time < N:
#     # 모든 빈 칸에 폭탄 놓기
#     for i in range(R):
#         for j in range(C):
#             if arr[i][j] == -1:
#                 arr[i][j] = 0
#             else:
#                 arr[i][j] = 2
#             q.append((i, j, arr[i][j]))
#
#     time += 1
#     if time == N:
#         break
#
#     # 1초 후 폭탄 폭발
#     while q:
#         ci, cj, ct = q.popleft()
#         if ct == 2:
#             arr[ci][cj] = -1
#             for di, dj in ((-1, 0), (0, 1), (1, 0), (0, -1)):
#                 ni = ci + di
#                 nj = cj + dj
#                 if 0 <= ni < R and 0 <= nj < C:
#                     arr[ni][nj] = -1
#         else:
#             if arr[ci][cj] != -1:
#                 arr[ci][cj] = 1
#
#     time += 1
#
# for i in range(R):
#     for j in range(C):
#         if arr[i][j] == -1:
#             print(".", end="")
#         else:
#             print("O", end="")
#     print()

# [2]