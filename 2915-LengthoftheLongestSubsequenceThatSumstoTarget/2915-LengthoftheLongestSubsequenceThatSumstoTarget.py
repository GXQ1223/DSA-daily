# Last updated: 6/23/2025, 6:10:44 PM
class Solution:
    def lengthOfLongestSubsequence(self, nums: List[int], target: int) -> int:
        dp = [-1] * (target + 1)
        dp[0] = 0
        for x in nums:
            for i in range(target, x-1, -1):
                if dp[i-x] != -1:
                    dp[i] = max(dp[i], dp[i-x] + 1)
        return dp[target]