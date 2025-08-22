# Last updated: 8/22/2025, 10:56:39 AM
class Solution:
    def minimumArea(self, grid: List[List[int]]) -> int:
        min_row, min_col, max_row, max_col = inf, inf, -inf, -inf
        m,n = len(grid), len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    min_row = min(min_row, i)
                    min_col = min(min_col, j)
                    max_row = max(max_row, i)
                    max_col = max(max_col, j)
        return (max_row - min_row + 1) * (max_col - min_col + 1)