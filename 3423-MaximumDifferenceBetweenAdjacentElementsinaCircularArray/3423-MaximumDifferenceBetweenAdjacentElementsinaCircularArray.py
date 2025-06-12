# Last updated: 6/11/2025, 11:07:52 PM
class Solution:
    def maxAdjacentDistance(self, nums: List[int]) -> int:
        res = max([abs(nums[i]-nums[i-1])for i in range(1, len(nums))])
        return max(res, abs(nums[-1] - nums[0]))