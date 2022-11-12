def solution(test):
    n, g, b = [x for x in test]
    require = 0
    if n%2 == 0:
        require = n//2
    else:
        require = n//2 + 1

    day = 0
    if require%g == 0:
        day = require + (require//g-1) * b
    else:
        div = require // g
        day = div*(g+b) + require%g
    
    if day < n:
        day = n
    print(day)

if __name__ == "__main__":
    test_case = int(input())
    test_input = []

    for i in range(test_case):
        ar = [int(x) for x in input().split()]
        test_input.append(ar)
    
    for test in test_input:
        solution(test)