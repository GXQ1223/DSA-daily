# Last updated: 8/16/2025, 11:08:00 PM
class Solution:
    def new21Game(self, n: int, k: int, maxPts: int) -> float:
        # k or more points means k, k+1,k+2...n, and n+1,n+2..., k-1+maxPts.
        dp = [0.0] * (n+1)
        dp[0] = 1.0
        s = 1 if k > 0 else 0
        for i in range(1, n+1):
            dp[i] = s / maxPts
            if i < k:
                s += dp[i]
            if i - maxPts >= 0 and i - maxPts < k:
                s -= dp[i-maxPts]
        return sum(dp[k:])