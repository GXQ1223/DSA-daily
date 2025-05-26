# Last updated: 5/26/2025, 12:45:42 AM
class Solution:
    def mostPoints(self, questions: List[List[int]]) -> int:
        n = len(questions)       
        dp = [0] * n
        dp[n-1] = questions[n-1][0] 
        if n == 1: return dp[0]
        res = questions[n-1][0]
        for i in range(n-2,-1,-1):
            dp[i] = max(dp[i+1], (dp[i+questions[i][1] + 1] if i+questions[i][1]+1 < n else 0) + questions[i][0])
            res = max(dp[i], res)
        return res