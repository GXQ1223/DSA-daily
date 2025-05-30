# Last updated: 5/30/2025, 1:59:37 PM
class Solution:
    def minScoreTriangulation(self, values: List[int]) -> int:
        # n = len(values)
        # @cache
        # def dfs(i,j):
        #     if i > j-2:
        #         return 0
        #     val = inf
        #     for k in range(i+1, j):
        #         val = min(val, dfs(i, k) + dfs(k, j) + values[i] * values[j] * values[k])
        #     return val
        # return dfs(0, n-1)

        n = len(values)
        f = [[0] * n for _ in range(n)]
        for i in range(n-3,-1,-1):
            for j in range(i+2, n):
                f[i][j] = inf
                for k in range(i+1, j):
                    f[i][j] = min(f[i][k] + f[k][j] + values[i]*values[j]*values[k], f[i][j])
        return f[0][n-1]