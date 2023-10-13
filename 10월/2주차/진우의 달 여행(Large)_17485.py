'''
6 4
5 8 5 1
3 5 8 4
9 77 65 5
2 1 5 2
5 98 1 5
4 95 67 58

29
'''

import sys
input = sys.stdin.readline

def dfs(k, cursum, d, cj):
    pass

N, M = map(int, input().split())
space = [list(map(int, input().split())) for _ in range(N)]
dp = [[0] * M for _ in range(N)]
_min = 987654321
for i in range(M):
    dfs(0, 0, -2, i)
print(_min)