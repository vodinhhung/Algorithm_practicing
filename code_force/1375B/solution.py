def generateNeighborMatrix(m,n):
    result = [ [0 for i in range(n)] for j in range(m)]
    for i in range(m):
        for j in range(n):
            if i == 0 or i == m-1:
                if j == 0 or j == n-1:
                    result[i][j] = 2
                else:
                    result[i][j] = 3
            else:
                if j == 0 or j == n-1:
                    result[i][j] = 3
                else:
                    result[i][j] = 4
    return result

def solution(ar):
    m = len(ar)
    n = len(ar[0])
    neighbor = generateNeighborMatrix(m,n)
    for i in range(m):
        for j in range(n):
            if ar[i][j] > neighbor[i][j]:
                print("No")
                return
    
    print("Yes")
    for i in range(m):
        string = ' '
        print(string.join(map(str, neighbor[i])))
    return        

if __name__ == "__main__":
    no_test_case = int(input())
    test_input = []
    for i in range(no_test_case):
        ar_input = []
        m, n = [int(x) for x in input().split()]
        for j in range(m):
            row = [int(x) for x in input().split()]
            ar_input.append(row)
        test_input.append(ar_input)
    
    for ar in test_input:
        solution(ar)