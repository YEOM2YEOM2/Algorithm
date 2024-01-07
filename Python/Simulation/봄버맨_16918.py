from collections import deque
import sys
input = sys.stdin.readline

# O 폭탄

# [1] 내 풀이 (4192ms), N^2

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

# [2] 그래프
# N 짝수일 때 모든 칸을 폭탄으로 출력함.
# 3, 7, 11 → 처음 설치된 폭탄(0, 4, 8 - cycle 1)이 터짐
# 5, 9, 13 → 나중에 설치된 폭탄(1, 5, 9 - cycle 2)이 터짐.
R, C, N = map(int, input().split())
arr = [list(input().strip()) for _ in range(R)]

if N == 1:
    for row in arr:
        print("".join(row))
elif N % 2 == 0:
    for _ in range(R):
        print("O"*C)
else:
    # cycle 1
    bombs = [["O"] * C for _ in range(R)]
    for i in range(R):
        for j in range(C):
            if arr[i][j] == "O":
                bombs[i][j] = "."
            else:
                for di, dj in ((-1, 0), (0, 1), (1, 0), (0, -1)):
                    ni = i + di
                    nj = j + dj
                    if 0 <= ni < R and 0 <= nj < C and arr[ni][nj] == "O":
                        bombs[i][j] = "."
                        break
    # cycle 2
    _bombs = [["O"] * C for _ in range(R)]
    for i in range(R):
        for j in range(C):
            if bombs[i][j] == "O":
                _bombs[i][j] = "."
            else:
                for di, dj in ((-1, 0), (0, 1), (1, 0), (0, -1)):
                    ni = i + di
                    nj = j + dj
                    if 0 <= ni < R and 0 <= nj < C and bombs[ni][nj] == "O":
                        _bombs[i][j] = "."
                        break

    if N % 4 == 3:
        for row in bombs:
            print("".join(row))
    elif N % 4 == 1:
        for row in _bombs:
            print("".join(row))