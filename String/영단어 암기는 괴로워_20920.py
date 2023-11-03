import sys
input = sys.stdin.readline

N, M = map(int, input().split())
words = {}
for _ in range(N):
    temp = input().strip()
    if len(temp) < M:
        continue

    if temp not in words:
        words[temp] = 1
    else:
        words[temp] += 1

ans = []
for key, value in words.items():
    ans.append((key, value))

ans.sort(key=lambda x:(-x[1], -len(x[0]), x[0]))
for word in ans:
    print(word[0])