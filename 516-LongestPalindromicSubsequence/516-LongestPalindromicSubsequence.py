# Last updated: 5/30/2025, 1:07:08 PM
class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        # @cache
        # def dfs(i, j):
        #     if i > j: # i, j are inclusive
        #         return 0
        #     if i == j:
        #         return 1
        #     if s[i] == s[j]:
        #         return 2 + dfs(i+1, j-1)
        #     else:
        #         return max(dfs(i+1, j), dfs(i, j-1))
        # return dfs(0, len(s) - 1)

        n = len(s)
        f = [[0] * n for _ in range(n)]
        for i in range(n-1, -1, -1):
            f[i][i] = 1
            for j in range(i+1, n):
                if s[i] == s[j]:
                    f[i][j] = 2 + f[i+1][j-1]
                else:
                    f[i][j] = max(f[i+1][j], f[i][j-1])
        return f[0][n-1]