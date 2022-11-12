def solution(test_input, sx, sy):
    directions = [[-1,0], [0,-1], [1,0], [0,1]]
    
    points = 0
    coordinate = [0,0]
    for direction in directions:
        px = sx + direction[0]
        py = sy + direction[1]
        local_points = 0
        for test in test_input:
            x = test[0]
            y = test[1]
            if (px-sx)*(px-x) <= 0 and (py-sy)*(py-y) <= 0:
                local_points += 1
        if local_points > points:
            points = local_points
            coordinate = [px, py]
    
    print(points)
    print(coordinate[0], coordinate[1])

if __name__ == "__main__":
    n, sx, sy = [int(x) for x in input().split()]
    test_input = []

    for i in range(n):
        ar = [int(x) for x in input().split()]
        test_input.append(ar)

    solution(test_input, sx, sy)