def solution(test):
    result = 0
    test.sort()
    index = 0
    current = 0
    while index < len(test):
        current += 1
        if current == test[index]:
            result += 1
            current = 0
        index += 1
    print(result)

# def solution2(test):
#     test.sort(reverse=True)
#     store = {}
#     result = dp(test, 0, store)
#     print(result)

# def dp(test, index, store):
#     if index >= len(test):
#         return -1
#     if index == len(test)-1:
#         if test[index] == 1:
#             store[index] = 1
#         else:
#             store[index] = 0
#     if index in store:
#         return store[index]
#     store[index] = max(dp(test, index+1, store), dp(test, index+test[index], store)+1)
#     return store[index]

if __name__ == "__main__":
    test_case = int(input())
    test_input = []

    for i in range(test_case):
        n = int(input())
        exper = [int(x) for x in input().split()]
        test_input.append(exper)
    
    for test in test_input:
        solution(test)