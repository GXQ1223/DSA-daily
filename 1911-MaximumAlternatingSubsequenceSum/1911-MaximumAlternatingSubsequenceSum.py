# Last updated: 7/7/2025, 7:07:35 PM
class Solution:
    def maxAlternatingSum(self, nums: List[int]) -> int:
        n = len(nums)
        max_plus, max_minus = nums[0], -inf
        for i in range(1, n):
            temp = max_plus
            summ = max(max_minus + nums[i], max_plus)
            summ = max(nums[i], summ)
            max_plus = max(max_plus, summ)
            diff = max(max_minus, temp - nums[i])
            max_minus = max(max_minus, diff)
        return max(max_plus, max_minus)
                