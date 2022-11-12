def minDays(n):
    store = [0, 1, 2, 2]
    if n <= 3:
        return store[n]
    for i in range(4, n+1):
        val = store[i-1]+1
        if i%2 == 0:
            val = min(val, store[i//2]+1)
        if i%3 == 0:
            val = min(val, store[i//3]+1)
        store.append(val)
    
    print(store)
    return store[n]

if __name__ == "__main__":
    n = int(input())
    print(minDays(n))