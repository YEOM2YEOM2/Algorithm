h, m  = map(int, input().split())
temp = 0
if m < 45:
    temp = 45 - m
    if h == 0:
        h = 23
    else:
        h -= 1
    print(f'{h} {60 - temp}')
else:
    print(f'{h} {m - 45}')