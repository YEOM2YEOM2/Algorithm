import sys
input = sys.stdin.readline

#  2 <= N <= 16 → DP, 비트마스킹, DFS
# 아래 코드 58% 시간 초과, 블로그 풀이 이해 안됨.
# https://programmer-hoo.tistory.com/59

def dfs(c, visited):
    if visited == (2**N) -1:
        if arr[c][0]:   # 마지막 도시에서 출발지로 돌아가는 경로가 있다면
            return arr[c][0]
        else:
            return INF

    if dp[c][visited] != INF+1: # 경로가 없는 것인지 방문한 곳인지 구분이 안됨. DP -1로 초기화 필요
        return dp[c][visited]

    for i in range(1, N):
        if not arr[c][i] or visited & (1 << i): # 가는 경로가 없음 or 이미 방문한 도시 건너 뛰기
            continue

        dp[c][visited] = min(dp[c][visited], dfs(i, visited | (1 << i)) + arr[c][i])

    if dp[c][visited] == -1: # 반복문을 다 돌아도 방문하지 못했을 경우 해당 경로에서는 유효한 경로가 없음.
        return INF

    return dp[c][visited]

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
INF = 987654321
dp = [[INF+1] * (2**N) for _ in range(N)]

print(dfs(0, 1))