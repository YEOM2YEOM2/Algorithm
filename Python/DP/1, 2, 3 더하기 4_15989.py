import sys
input = sys.stdin.readline

# [1] 수학, 내 풀이
T = int(input())
# for _ in range(T):
#     N = int(input())
#     cnt3 = [i for i in range(N//3+1)]
#     ans = 0
#
#     for val in cnt3:
#         temp = N - val * 3
#         ans += (temp // 2) + 1
#
#     print(ans)

# [2] dp
dp = [1] * 10001

for i in range(2, 10001):
    dp[i] += dp[i-2]

for i in range(3, 10001):
    dp[i] += dp[i-3]

for _ in range(T):
    n = int(input())
    print(dp[n])