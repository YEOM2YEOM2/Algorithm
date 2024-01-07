import sys
input = sys.stdin.readline

N = int(input())
arr = [[0] * N for _ in range(N)]
like_list = [0] * (N*N+1)
for _ in range(N*N):
    num, *like = map(int, input().split())
    like_list[num] = like
    # cand[i][j][0] : 인접한 좋아하는 학생 수, cand[i][j][1] : 인접한 비어있는 칸 수
    cand = []
    # 비어있는 칸 중에서 좋아하는 학생이 가장 많은 칸 찾기
    for i in range(N):
        for j in range(N):
            blank, cnt = 0, 0
            # 비어있는 칸 판단하기
            if not arr[i][j]:
                for di, dj in ((-1, 0), (0, 1), (1, 0), (0, -1)):
                    ni = i + di
                    nj = j + dj
                    if 0 <= ni < N and 0 <= nj < N:
                        if not arr[ni][nj]:
                            blank += 1
                        elif arr[ni][nj] and arr[ni][nj] in like:
                            cnt += 1
                cand.append([cnt, blank, i, j])
    cand.sort(key=lambda x: (-x[0], -x[1], x[2], x[3]))
    arr[cand[0][2]][cand[0][3]] = num

# 만족도 구하기
ans = 0
for i in range(N):
    for j in range(N):
        temp = 0
        for di, dj in ((-1, 0), (0, 1), (1, 0), (0, -1)):
            ni = i + di
            nj = j + dj
            if 0 <= ni < N and 0 <= nj < N and arr[ni][nj] in like_list[arr[i][j]]:
                temp += 1
        if temp:
            ans += 10 ** (temp-1)
print(ans)