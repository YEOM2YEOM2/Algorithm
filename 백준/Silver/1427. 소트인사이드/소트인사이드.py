lst = list(map(int, list(input())))
lst.sort(reverse = True)
for n in lst:
    print(n, end="")