# Last updated: 5/30/2025, 1:44:30 PM
class Solution:
    def minScoreTriangulation(self, values: List[int]) -> int:
        n = len(values)
        @cache
        def dfs(i,j):
            if i > j-2:
                return 0
            val = inf
            for k in range(i+1, j):
                val = min(val, dfs(i, k) + dfs(k, j) + values[i] * values[j] * values[k])
            return val
        return dfs(0, n-1)