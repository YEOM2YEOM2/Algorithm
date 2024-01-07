import sys
input = sys.stdin.readline

N = int(input())
ans, stack = 0, []
for _ in range(N):
    dump, num = map(int, input().split())
    if stack:
        if stack[-1] < num:     # 상승
            stack.append(num)
        elif stack[-1] > num:   # 하강
            while stack and stack[-1] > num:
                temp = stack.pop()
                ans += 1
            if stack and stack[-1] < num:   # stack[-1]은 현재 건물의 (최고) 높이여야 함.
                stack.append(num)
            elif not stack and num != 0:    # stack이 비었는데 num != 0이 아니면 현재 건물의 높이여야 함.
                stack.append(num)
    else:
        if num != 0:
            stack.append(num)

print(ans + len(stack))