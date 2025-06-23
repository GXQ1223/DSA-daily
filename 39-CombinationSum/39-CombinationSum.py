# Last updated: 6/23/2025, 4:28:13 PM
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        res = [n * [0] for _ in range(m)]
        res[0][0] = grid[0][0]
        for i in range(1,m): res[i][0] = res[i-1][0] + grid[i][0]
        for i in range(1,n): res[0][i] = res[0][i-1] + grid[0][i]
        for i in range(1, m):
            for j in range(1, n):
                res[i][j] = min(res[i-1][j], res[i][j-1]) + grid[i][j]
        return res[m-1][n-1]