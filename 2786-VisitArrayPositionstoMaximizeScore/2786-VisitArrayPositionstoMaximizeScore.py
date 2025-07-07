# Last updated: 7/7/2025, 6:50:44 PM
class Solution:
    def maxScore(self, nums: List[int], x: int) -> int:
        # max_even, max_odd = -inf, -inf
        # @cache
        # def dfs(i):
        #     nonlocal max_even
        #     nonlocal max_odd
        #     # print("max_even: ", max_even, "; max_odd: ", max_odd)
        #     if i == 0:
        #         max_even = nums[0] if nums[0] % 2 == 0 else -inf
        #         max_odd = nums[0] if nums[0] % 2 == 1 else -inf
        #         return nums[0]
        #     if nums[i] % 2 == 0:
        #         even = max(max_even + nums[i], max_odd - x + nums[i])
        #         max_even = max(even, max_even)
        #         # print("nums[",i,"]:", nums[i], "; i(even): ", even)
        #         return even
        #     else:
        #         odd = max(max_even + nums[i] - x, max_odd + nums[i])
        #         max_odd = max(odd, max_odd)
        #         # print("nums[",i,"]:", nums[i], "; i(odd): ", odd)
        #         return odd
            
            
        # return max(dfs(i) for i in range(len(nums)))
        

        n = len(nums)
        max_even, max_odd = -inf if nums[0] % 2 else nums[0], -inf if not nums[0] % 2 else nums[0]
        res = max(max_even, max_odd)
        for i in range(1, n):
            if not nums[i] % 2:
                even = max(max_even, max_odd - x) + nums[i]
                max_even = max(even, max_even)
                res = max(res, max_even)
            else:
                odd = max(max_odd, max_even - x) + nums[i]
                max_odd = max(odd, max_odd)
                res = max(res, max_odd)
        return res