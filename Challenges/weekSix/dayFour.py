# TODO FloodFill
# ------------------------------------------------------------------------------------------------------------
# Start on a point 
canvas2D = [
    [3,2,3,4,3],
    [2,3,3,4,0],
    [7,3,3,5,3],
    [6,5,3,4,1],
    [1,2,3,3,3]
]

def flood_fill(map,startXY,new_color,old_color=-1):
    print(map,startXY)
    if old_color == -1:
        old_color = map[startXY[0]][startXY[1]]
    
    if map[startXY[0]][startXY[1]] == old_color:
       map[startXY[0]][startXY[1]] = new_color
       if startXY[1] < len(map[0]) and startXY[0] >= 0:
        startXY[0] -= 1
        flood_fill(map,startXY,new_color,old_color)
    
    return map

print(canvas2D)
print(flood_fill(canvas2D,[2,2],1))


canvas2D_result = [
    [3,2,1,4,3],
    [2,1,1,4,0],
    [7,1,1,5,3],
    [6,5,1,4,1],
    [1,2,1,1,1]
]

# print(flood_fill(canvas2D,[2,2],1))