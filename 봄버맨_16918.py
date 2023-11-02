import sys
input = sys.stdin.readline

# O 폭탄

R, C, N = map(int, input().split())
bombs = [list(input().strip()) for _ in range(R)]
