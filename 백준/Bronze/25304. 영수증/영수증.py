N = int(input())
M = int(input())

sum = 0
for i in range(M):
    a, b = map(int, input().split())
    sum += a * b;

if sum == N:
    print("Yes")
else:
    print("No")