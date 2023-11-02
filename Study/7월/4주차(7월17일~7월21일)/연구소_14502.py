import sys
input = sys.stdin.readline

def bfs():
    pass

def comb(r, s, k):
    global cnt

    if k == 3:
        cnt += 1
        return

    for i in range(s, blank_leng-r+k):
        order[k] = blank[i]
        comb(r, s+1, k+1)



# 0 빈칸, 1 벽, 2 바이러스
N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

blank = []
for i in range(N):
    for j in range(M):
        if not arr[i][j]:
            blank.append([i, j])
cnt = 0
order = [0] * 3
blank_leng = len(blank)
comb(3, 0, 0)
print(cnt)