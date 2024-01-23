import sys
input = sys.stdin.readline

N = int(input())
body = []
ans = []
for i in range(N):
    x, y = map(int, input().split())
    sum = x + y
    body.append([i, x, y, sum])

body.sort(key = lambda x : -x[3])

body[0].append(1)
for i in range(1, N):
    # 이전 인덱스의 키와 몸무게가 현재 인덱스보다 크다면 이전 등수보다 낮은 등수를 가짐.
    cnt = 1
    for j in range(i):
        if body[j][1] > body[i][1] and body[j][2] > body[i][2]:
            cnt += 1

    body[i].append(cnt)


body.sort(key = lambda x : x[0])
for i in range(N):
    print(body[i][4], end = " ")