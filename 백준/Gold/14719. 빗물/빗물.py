import sys
input = sys.stdin.readline

H, W = map(int, input().split())
height = list(map(int, input().split()))
arr = [[0] * W for _ in range(H)]

for w in range(W):
    for h in range(height[w]):
        arr[H -1 - h][w] = 1

ans = 0
for i in range(H):
    flag = cnt = 0
    for j in range(W):
        # 블록을 만난 적 없고 블록을 만났을 때
        if not flag and arr[i][j]:
            flag = 1
        # 블록을 만났고 빈 공간을 만났을 때
        elif flag and not arr[i][j]:
            cnt += 1
        # 블록을 만났고 블록을 만났을 때
        elif flag and arr[i][j]:
            ans += cnt
            cnt = 0

print(ans)