# Last updated: 7/7/2025, 6:52:19 PM
class Solution:
    def maxScore(self, nums: List[int], x: int) -> int:
        n = len(nums)
        me = 0
        mo = 0
        sol = 0
        for i in range(n-1,-1,-1):
            if nums[i] % 2 == 0:
                me = nums[i] + max(me, mo-x)
            else:
                mo = nums[i] + max(mo, me-x)
        if nums[0] % 2 == 0:
            return me
        return mo