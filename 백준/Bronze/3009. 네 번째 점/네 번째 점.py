x_cnt = {}
y_cnt = {}
for _ in range(3):
    x, y = map(int, input().strip().split())
    if x in x_cnt:
        x_cnt[x] = x_cnt[x] + 1;
    else:
        x_cnt[x] = 1;

    if y in y_cnt:
        y_cnt[y] = y_cnt[y] + 1;
    else:
        y_cnt[y] = 1;

ans_x, ans_y = 0, 0
for k, v in x_cnt.items():
    if v == 1:
        ans_x = k

for k, v in y_cnt.items():
    if v == 1:
        ans_y = k

print(ans_x, ans_y)