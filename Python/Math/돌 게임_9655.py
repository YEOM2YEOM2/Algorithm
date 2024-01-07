import sys
input = sys.stdin.readline

# 상근이 먼저 시작, 돌 - 1 or 3개씩만 가져갈 수 있음.
N = int(input())

if N % 2 == 0:
    print("CY")
else:
    print("SK")