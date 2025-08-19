# Last updated: 8/19/2025, 1:51:58 AM
class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        res = []
        i = 0
        while i <= len(nums) - 1:
            continued = 0
            if nums[i] == 0:
                continued = 1
                while i + 1 < len(nums) and nums[i+1] == nums[i]:
                    i += 1
                    continued += 1
            res.append(continued)
            i += 1
        ans = 0
        for x in res:
            ans += (1 + x) * x // 2
        return ans