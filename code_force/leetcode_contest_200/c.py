def minSwaps(grid):
    store = {}
    n = len(grid)
    for i in range(n):
        count_zero = 0
        for num in reversed(grid[i]):
            print(num)
            if num == 0:
                count_zero += 1
            else:
                break
        if count_zero in store:
            return -1
        else:
            store[count_zero] = i
    print(store)
    swap = 0
    index = 0
    for i in range(n):
        print("add value",abs(store[n-i-1] - i))
        swap += abs(store[n-i-1] - i)
        for key in store:
            if store[key] < store[n-i-1]:
                store[key] += 1
        del store[n-i-1]
        print(store, "store after edit")
    
    return swap

if __name__ == "__main__":
    grid = [[1,0,0,0],[1,1,1,1],[1,0,0,0],[1,0,0,0]]
    print(minSwaps(grid))