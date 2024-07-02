n = int(input())
lst = list(map(int, input().split()))
d = {}
for i in range(n):
    d[lst[i]] = 1

m = int(input())
lst = list(map(int, input().split()))
for i in range(m):
    if lst[i] in d: print(1, end=" ")
    else: print(0, end=" ")