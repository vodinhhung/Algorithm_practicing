def solution(test):
    a, b, c = 0, 0, 0
    l, r, m = [x for x in test]
    for i in range(l, r+1):
        if m+l-r <= 0:
            a = i
            b = l
            c = i-m+b
            break
        else:
            if (m+l-r)//i == (m+r-l)//i:
                continue
            else:
                n = (m+r-l)//i
                a = i
                if a*n-m > 0:
                    b = l
                else:
                    b = r
                c = b + a*n - m
                break
    print(a,b,c)

if __name__ == "__main__":
    test_case = int(input())
    test_input = []

    for i in range(test_case):
        ar = [int(x) for x in input().split()]
        test_input.append(ar)
        solution(ar)