import sys
input = sys.stdin.readline

N, K = map(int, input().split())
medal = []

for _ in range(N):
    temp = list(map(int, input().split()))
    medal.append(temp)

medal.sort(key=lambda x : (x[1], x[2], x[3]), reverse=True)
medal[0].append(1)

cnt = 1
for i in range(1, N):
    # 현재 금메달 개수가 이전 금메달 개수보다 작으면
    if medal[i-1][1] > medal[i][1]:
        medal[i].append(medal[i-1][4] + cnt)
        cnt = 1
    # 이미 메달 순으로 정렬해놔서 현재 금메달 개수가 이전 금메달 개수보다 클 일이 없음.
    else:
        # 현재 은메달 개수가 이전 은메달 개수보다 작으면
        if medal[i-1][2] > medal[i][2]:
            medal[i].append(medal[i - 1][4] + cnt)
            cnt = 1
        else:
            if medal[i-1][3] > medal[i][3]:
                medal[i].append(medal[i - 1][4] + cnt)
                cnt = 1
            else:
                medal[i].append(medal[i-1][4])
                cnt += 1

for i in range(N):
    if medal[i][0] == K:
        print(medal[i][4])