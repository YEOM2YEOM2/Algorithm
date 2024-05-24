N = int(input())
lst = []
for _ in range(N):
    x, y = map(int, input().split())
    lst.append([x, y])
lst.sort(key = lambda x : (x[1], x[0]))

for i in range(N):
    print(f'{lst[i][0]} {lst[i][1]}')