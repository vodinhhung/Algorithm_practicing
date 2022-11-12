def solution(test):
    result = []
    a = test[0]
    p = test[1]
    check = [0 for i in range(len(a))]
    for index in p:
        if index <= len(a): check[index-1] = index
    first = 0
    second = 0
    while second < len(a):
        if check[first] == 0:
            result.append(a[first])
            first += 1
            second += 1
        else:
            while second < len(a) and check[second] == second+1:
                second +=1
            for i in sorted(a[first:second+1]):
                result.append(i)
            second += 1
            first = second
        if result[i] > result[i+1]:
            print("No")
            return
    
    print("Yes")

if __name__ == "__main__":
    test_number = int(input())
    test_input = []
    
    for i in range(test_number):
        m, n = [int(x) for x in input().split()]
        ar = [int(x) for x in input().split()]
        pr = [int(x) for x in input().split()]
        test_input.append([ar,pr])
    
    for test in test_input:
        solution(test)