def solution(test):
    sum = 0
    for i in test:
        sum += i
        if sum <= 0:
            print("NO")
            return
    
    sum = 0
    for i in reversed(test):
        sum += i
        if sum <= 0:
            print("NO")
            return
    
    print("YES")

if __name__ == "__main__":
    test_case = int(input())
    test_input = []

    # Input
    for i in range(test_case):
        n = int(input())
        ar = [int(x) for x in input().split()]
        test_input.append(ar)
    
    # Output
    for test in test_input:
        solution(test)