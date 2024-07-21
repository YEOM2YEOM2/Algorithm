n, m = map(int, input().split())
lst = [i for i in range(n + 1)]
for _ in range(m):
    num1, num2 = map(int, input().split())
    lst[num1], lst[num2] = lst[num2], lst[num1]

for i in range(1, n + 1):
    print(lst[i], end=" ")