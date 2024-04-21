n, m = map(int, input().split())
arr = [0] * (n+1)
for _ in range(m):
    s, e, k = map(int, input().split())
    for i in range(s, e+1):
        arr[i] = k
for i in range(1, n+1):
    print(arr[i], end = " ")