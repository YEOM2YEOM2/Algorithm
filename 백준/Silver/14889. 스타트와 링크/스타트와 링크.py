import sys
input = sys.stdin.readline

# dfs, visited 이용해서 방문한 팀 → start / 방문 안한 팀 → link
def dfs(s, k):
    global _min

    if k == N // 2:
        s_sum = l_sum = 0
        # arr[i][j], i == j 일 때의 값은 0으로 이미 주어짐. 따로 조건으로 빼서 처리할 필요 x
        for i in range(N):
            for j in range(i, N):
                # visited[i] & visited[j] 모두 방문했다면 start팀에 속한 선수들이므로 s_sum에 더 해줌.
                if visited[i] and visited[j]:
                    s_sum += arr[i][j] + arr[j][i]
                # i, j 둘 다 방문하지 않았다면 link 팀
                elif not visited[i] and not visited[j]:
                    l_sum += arr[i][j] + arr[j][i]
        _min = min(_min, abs(s_sum-l_sum))

    else:
        # 시작 지점 부터 시작, 깊이가 깊어질 때마다 for문의 시작 idx가 +1이 되어야 중복되지 않음.
        for i in range(s, N):
            if not visited[i]:
                visited[i] = 1
                dfs(i+1, k+1)
                visited[i] = 0


N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

visited = [0] * N
_min = 987654321

dfs(0, 0)
print(_min)