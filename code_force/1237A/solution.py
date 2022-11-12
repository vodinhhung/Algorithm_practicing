def solution(arr):
    result = []
    sum = 0
    for i in arr:
        result.append(i//2)
        sum += i // 2
    
    index = len(arr) - 1
    while sum != 0 and index >= 0:
        if arr[index] % 2 != 0:
            result[index] += 1
            sum += 1
        index -= 1

    return result

if __name__ == "__main__":
    num_test = int(input())
    arr = []

    for i in range(num_test):
        change = int(input())
        arr.append(change)

    result = solution(arr)
    for i in result:
        print(i)