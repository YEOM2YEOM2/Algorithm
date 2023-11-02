import sys

input = sys.stdin.readline
sys.setrecursionlimit(100000)
n, m = map(int, input().split())


def union(x, y):
    x = find(x)
    y = find(y)
    if x == y:
        return
    parent[x] = y
    return


def find(x):
    if parent[x] == x:
        return x
    parent[x] = find(parent[x])
    return parent[x]


parent = [0] * (n + 1)
for i in range(n + 1):
    parent[i] = i

for i in range(m):
    x, a, b = map(int, input().split())
    if x == 0:
        union(a, b)
    else:
        pa = find(a)
        pb = find(b)
        if pa == pb:
            print('YES')
        else:
            print('NO')