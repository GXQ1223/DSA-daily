# Last updated: 7/7/2025, 7:06:21 PM
class Solution:
    def maxAlternatingSum(self, nums: List[int]) -> int:
        n = len(nums)
        max_plus = nums[0]
        max_minus = -inf
        res = 0
        for i in range(1, n):
            temp_plus = max_plus
            summ = max(max_minus + nums[i], max_plus)
            summ = max(nums[i], summ)
            max_plus = max(max_plus, summ)
            diff = max(max_minus, temp_plus - nums[i])
            max_minus = max(max_minus, diff)
            res = max(res, summ)
            res = max(res, diff)
        return max(max_plus, max_minus)
        
                