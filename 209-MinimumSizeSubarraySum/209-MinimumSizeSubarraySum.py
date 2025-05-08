# Last updated: 5/8/2025, 3:30:11 PM
class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        n = len(nums)
        ans = inf
        l = 0
        s = 0
        for r in range(0, n):
            s += nums[r]
            while s - nums[l] >= target:
                s -= nums[l]
                l += 1
            if s >= target:
                ans = min(ans, r - l + 1)
        return ans if ans <= n else 0