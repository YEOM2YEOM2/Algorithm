import sys
input = sys.stdin.readline

H, W, X, Y = map(int, input().split())
A = [[0] * W for _ in range(H)]
B = [list(map(int, input().split())) for _ in range(H+X)]

for i in range(H):
    for j in range(W):
        A[i][j] = B[i][j]

for i in range(X, H+X):
    for j in range(Y, W+Y):
        temp = B[i][j] - A[i-X][j-Y]
        if i < H and j < W:
            A[i][j] = temp

for lst in A:
    print(*lst)