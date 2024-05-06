import sys
input = sys.stdin.readline

N = int(input())
lst = []
for _ in range(N):
    lst.append(int(input()))
lst.sort();
for i in range(N):
    print(lst[i])