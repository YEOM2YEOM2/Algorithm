name = n = 0
for _ in range(7):
    name_temp, n_temp = input().split()
    n_temp = int(n_temp)
    if n < n_temp:
        name = name_temp
        n = n_temp
print(name)