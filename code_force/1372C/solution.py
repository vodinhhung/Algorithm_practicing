def solution(test):
    answer = 0
    for i in range(len(test)-1):
        if test[i] > test[i+1]:
            answer = 1

    if answer != 0:
        stage = 0

        for i in range(len(test)):
            if test[i] != i+1:
                if stage == 0:
                    stage = 1
                elif stage == 1:
                    continue
                else:
                    answer = 2
                    break
            else:
                if stage == 1:
                    stage = 2
    
    return answer

if __name__ == "__main__":
    test_case = int(input())
    
    for i in range(test_case):
        n = int(input())
        ar = [int(x) for x in input().split()]
        print(solution(ar))