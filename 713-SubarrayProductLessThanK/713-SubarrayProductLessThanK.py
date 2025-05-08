# Last updated: 5/8/2025, 3:52:36 PM
class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        if k <= 1:
            return 0
        n = len(nums)
        res = 0
        m = 1
        l = 0
        for r in range(0, n):
            m *= nums[r]
            while m >= k:
                m /= nums[l]
                l += 1
            res += r - l + 1
        return res
        