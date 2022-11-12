from math import sqrt

def solution(n):
    sum = 0
    sqr = int(sqrt(n))
    for i in range(1, sqr+1):
        if n%i==0:
            sum += n//i + i

    if sum == n*2:
        print("YES")
    else:
        print("NO")

if __name__ == "__main__":
    test_case = int(input())
    for i in range(test_case):
        n = int(input())
        solution(n)