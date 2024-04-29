def promising(x):
    for i in range(x):
        if abs(row[x]-row[i]) == x-i:
            return False
    return True


def queen(k, N):
    global cnt
    if k == N:
        cnt += 1
    else:
        for i in range(N):
            if not visited[i]:  # i번째 열에 퀸이 놓여있지 않다면
                # 2차원 배열 기준, arr[k][i]에 퀸을 놓음.
                row[k] = i
                if promising(k):    # k번째 열에 퀸을 놓는 것이 유망한 지 체크
                    visited[i] = 1
                    queen(k+1, N)   # 다음 열에 퀸을 놓음.
                    visited[i] = 0


N = int(input())
row = [0] * N
# visited[idx] = 1 -> 해당 인덱스 열(세로)에 이미 퀸이 존재함.
visited = [0] * N
cnt = 0
queen(0, N)
print(cnt)