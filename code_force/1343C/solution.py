from heapq import heapify, heappop, heappush

def solution(ar):
    first, second, result = 0, 0, 0
    while second < len(ar):
        heap = []
        heapify(heap)
        heappush(heap, -1 * ar[first])
        while second < len(ar) and ar[first]*ar[second] > 0:
            heappush(heap, -1 * ar[second])
            second += 1
        result += -1 * heappop(heap)
        first = second
        
    return result

if __name__ == "__main__":
    test_number = int(input())
    ar_input = []

    for i in range(test_number):
        size = input()
        ar = [int(x) for x in input().split()]
        ar_input.append(ar)
    
    for ar in ar_input:
        print(solution(ar))