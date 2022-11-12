num = int(input())

ar = [int(x) for x in input().split()]

store = {0: 0, 1: 0}
value = 0
for i in ar:
    value += i
    if i%2 == 0:
        store[0] += 1
    else: 
        store[1] += 1

if value%2 == 0:
    print(store[0])
else:
    print(store[1])