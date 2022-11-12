def solution(arr):
    sum = 0
    for i in arr:
        sum += i - 1
        if sum%2 == 0:
            print("2")
        else:
            print("1")

if __name__ == "__main__":
    test = int(input())
    ar = [int(x) for x in input().split()]

    solution(ar)