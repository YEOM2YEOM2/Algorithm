import sys
from collections import deque;
input = sys.stdin.readline

N, K = map(int, input().split())
belt = deque(list(map(int, input().split())))
robot = deque([0] * N)
ans = 0

while True:
    ans += 1
    # 컨베이어 벨트 회전과 동시에 로봇도 회전
    belt.rotate(1)
    robot.rotate(1)
    robot[N-1] = 0

    if sum(robot): # 컨베이어 벨트 위에 올라간 로봇이 존재하면
        for i in range(N-2, -1, -1): # 가장 먼저 올라간 로봇부터 앞 칸으로 이동
            if robot[i] and not robot[i+1] and belt[i+1] > 0: # 로봇이 현재 idx칸에 존재o 이동할 앞 칸에는 로봇이 존재 x 이동할 칸의 컨베이어벨트의 내구도 >= 1
                robot[i] = 0
                robot[i+1] = 1
                belt[i+1] -= 1

        # 내리는 위치 로봇 제거
        robot[N-1] = 0

    if not robot[0] and belt[0] > 0:
        robot[0] = 1
        belt[0] -= 1

    if belt.count(0) >= K:
        break

print(ans)