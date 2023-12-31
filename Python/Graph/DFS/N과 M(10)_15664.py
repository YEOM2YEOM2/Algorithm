import sys
input = sys.stdin.readline

def dfs(s, k):
    if k == M:
        print(*order)
        return

    pre = 0
    for i in range(s, N):
        if pre != nums[i]:
            order[k] = nums[i]
            pre = nums[i]
            dfs(i+1, k+1)

N, M = map(int, input().split())
nums = sorted(list(map(int, input().split())))
order = [0] * M
dfs(0, 0)