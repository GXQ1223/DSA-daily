# Last updated: 6/25/2025, 6:56:19 PM
class Solution:
    def minDistance(self, s1: str, s2: str) -> int:
        dp = [[0] * (len(s1)+1) for _ in range(len(s2)+1)]
        for i in range(1, len(s1)+1): dp[0][i] = 1 + dp[0][i-1]
        for i in range(1, len(s2)+1): dp[i][0] = 1 + dp[i-1][0]

        for i in range(1, len(s2)+1):
            for j in range(1, len(s1)+1):
                if s2[i-1] == s1[j-1]:
                    dp[i][j] = dp[i-1][j-1]
                else:
                    dp[i][j] = min(dp[i-1][j]+1, dp[i][j-1]+1)
            # print()
            # for i in dp: print(i)
        return dp[len(s2)][len(s1)]        