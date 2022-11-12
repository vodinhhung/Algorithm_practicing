def solution(grid):
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            if grid[i][j] == 1:
                grid[i][j] = 2
    for row in grid:
        string = ""
        print(string.join([str(ele) for ele in row]))

if __name__ == "__main__":
    test_case = int(input())
    test_input = []

    for i in range(test_case):
        grid = []
        for j in range(9):
            ar = [int(x) for x in str(input())]
            grid.append(ar)
        test_input.append(grid)
    
    for test in test_input:
        solution(test)