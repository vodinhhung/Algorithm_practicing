def solution(ar):
    index = 0
    while index < len(ar):
        if ar[index] > 1:
            break
        else:
            index += 1
    if index == len(ar):
        index -= 1
    if index % 2 == 0:
        print("First")
    else:
        print("Second")


if __name__ == "__main__":
    test_case_no = int(input())
    test = []
    for i in range(test_case_no):
        piles = input()
        ar = [int(x) for x in input().split()]
        test.append(ar)
    
    for ar in test:
        solution(ar)