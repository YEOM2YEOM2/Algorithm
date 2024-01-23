import sys
input = sys.stdin.readline

N = int(input())
temp, ans = 1, 0

while True:
    temp += 6 * ans

    if N <= temp:
        break

    ans += 1

print(ans+1)