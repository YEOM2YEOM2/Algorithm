import sys
input = sys.stdin.readline

def dfs(egg_idx):
    global ans

    if egg_idx == N:
        cnt = 0
        for i in range(N):
            if egg[i][0] <= 0:
                cnt += 1
        ans = max(ans, cnt)
        return

    if egg[egg_idx][0] > 0:
        flag = 1   # 깨지지 않은 다른 계란이 있음
        for i in range(N):
            if i != egg_idx and egg[i][0] > 0:
                flag = 0    # 깰 수 있는 계란 있음
                egg[i][0] -= egg[egg_idx][1]
                egg[egg_idx][0] -= egg[i][1]
                dfs(egg_idx + 1)
                egg[i][0] += egg[egg_idx][1]
                egg[egg_idx][0] += egg[i][1]
        if flag:
            dfs(N)
    else:
        dfs(egg_idx + 1)


N = int(input())
egg = [list(map(int, input().split())) for _ in range(N)]
ans = 0
dfs(0)
print(ans)