def solution(k, ar):
    n = len(ar)
    store = [0 for i in range(n)]
    peaks = {}
    for i in range(1, n-1):
        if ar[i] > ar[i-1] and ar[i] > ar[i+1]:
            store[i] = store[i-1]+1
            peaks[i] = True
        else:
            store[i] = store[i-1]
    store[n-1] = store[n-2]
    max_part = 0
    index = 0
    for i in range(n-k+1):
        local = store[i+k-1] - store[i]
        if i+k-1 in peaks:
            local -= 1
        if max_part < local+1:
            max_part = local+1
            index = i
    
    print(max_part, index+1)

if __name__ == "__main__":
    test_case = int(input())
    test_input = []

    for i in range(test_case):
        n, k = [int(x) for x in input().split()]
        ar = [int(x) for x in input().split()]
        test_input.append([k, ar])
    
    for test in test_input:
        k = test[0]
        ar = test[1]
        solution(k ,ar)