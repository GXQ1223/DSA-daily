# Last updated: 8/22/2025, 11:02:17 AM
class Solution:
    def minimumArea(self, grid: List[List[int]]) -> int:
        minRow = len(grid)
        maxRow = -1
        minColumn = len(grid[0])
        maxColumn = -1
        
        for x, row in enumerate(grid):
            for y, val in enumerate(row):
                if val == 1:
                    if x < minRow:
                        minRow = x
                    if x > maxRow:
                        maxRow = x
                    if y < minColumn:
                        minColumn = y
                    if y > maxColumn:
                        maxColumn = y
        print("maxC", maxColumn)
        print("minC", minColumn)
        print("maxR", maxRow)
        print("minR", minRow)
        return (maxColumn - minColumn + 1) * (maxRow - minRow + 1)
        