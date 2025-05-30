# Last updated: 5/30/2025, 1:43:38 PM
class Solution:
    def minScoreTriangulation(self, values: List[int]) -> int:
        n = len(values)
        @cache
        def dfs(i,j):
            if i > j-2:
                return 0
            if i == j-2:
                return values[i] * values[i+1] * values[i+2]
            val = inf
            for k in range(i+1, j):
                val = min(val, dfs(i, k) + dfs(k, j) + values[i] * values[j] * values[k])
            return val
        return dfs(0, n-1)