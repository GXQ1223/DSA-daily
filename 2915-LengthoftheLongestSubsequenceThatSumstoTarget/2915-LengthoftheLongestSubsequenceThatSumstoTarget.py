# Last updated: 6/23/2025, 5:48:33 PM
class Solution:
    def lengthOfLongestSubsequence(self, w: List[int], target: int) -> int:
        # how to use dfs?
        # @cache
        # def dfs(i, c):
        #     if i < 0:
        #         return 0 if c == 0 else -1
        #     choose = dfs(i-1, c - w[i])
        #     if choose >= 0:
        #         return max(choose + 1, dfs(i-1, c))
        #     else:
        #         return max(choose, dfs(i-1, c))
        # return dfs(len(w)-1, target)
        n = len(w)
        dp = [[-1] * (target + 1) for _ in range(n)]
        # dp[0][0] = 0
        # for i in range(n):
        #     for j in range(target + 1):
                
        #         if j == 0:
        #             dp[i][j] = 0
        #         if i == 0:
        #             dp[i][j] = 1 if w[i] == j else -1
               
        #         choose = dp[i-1][j - w[i]]
        #         if choose == -1:
        #             choose = -2
        #         dp[i][j] = max(choose + 1, dp[i-1][j])
        # for i in dp:
        #     print(i)
        # return dp[n - 1][target]
        # base cases
        dp[0][0] = 0  # sum = 0 is always possible with 0 elements
        if w[0] <= target:
            dp[0][w[0]] = 1  # if we use w[0], we get sum w[0] with length 1
        
        for i in range(1, n):
            for j in range(target + 1):
                # skip w[i]
                if dp[i-1][j] != -1:
                    dp[i][j] = dp[i-1][j]
                
                # take w[i] if possible
                if j >= w[i] and dp[i-1][j - w[i]] != -1:
                    dp[i][j] = max(dp[i][j], dp[i-1][j - w[i]] + 1)
        
        return dp[n - 1][target]