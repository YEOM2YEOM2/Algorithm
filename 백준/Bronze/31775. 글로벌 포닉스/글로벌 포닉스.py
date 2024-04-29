cnt = [False, False, False]
for _ in range(3):
    temp = input().strip()
    if temp[0] == 'l':
        cnt[0] = True
    elif temp[0] == 'k':
        cnt[1] = True
    elif temp[0] == 'p':
        cnt[2] = True

flag = True;
for i in range(3):
    if cnt[i] == False:
        print("PONIX")
        flag = False;
        break;
if flag:
    print("GLOBAL")