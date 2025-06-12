# Last updated: 6/11/2025, 11:08:43 PM
class Solution:
    def maxAdjacentDistance(self, nums: List[int]) -> int:
        return max([abs(nums[i]-nums[i-1])for i in range(0, len(nums))])