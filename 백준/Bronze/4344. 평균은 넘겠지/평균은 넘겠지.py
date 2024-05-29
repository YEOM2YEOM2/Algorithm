T = int(input())
for _ in range(T):
    n, *score = map(int, input().split())
    avg = sum(score) / n
    
    cnt = 0
    for s in score:
        if avg < s: cnt+= 1
    
    print("{0:.3f}".format(cnt / n * 100) + "%")