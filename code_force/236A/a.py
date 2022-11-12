name = input()
store = {}
count = 0

for i in name:
    if i not in store:
        count += 1
        store[i] = 1

if count % 2 == 0:
    print("CHAT WITH HER!")
else:
    print("IGNORE HIM!")