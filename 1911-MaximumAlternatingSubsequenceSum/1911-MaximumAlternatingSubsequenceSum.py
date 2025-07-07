# Last updated: 7/7/2025, 7:11:38 PM
class Solution:
    def maxAlternatingSum(self, nums: List[int]) -> int:
        
        """
        goingDown is meant to represent that it is waiting to
        go down as we want to maximize the sum so we want to
        maximize adds and minimize subtractions
        """
        goingDown = True
        ans = 0
        
        for idx in range(len(nums)-1):
            if goingDown and nums[idx]>=nums[idx+1]:
                ans += nums[idx]
                goingDown = not goingDown
            elif not goingDown and nums[idx]<=nums[idx+1]:
                ans -= nums[idx]
                goingDown = not goingDown

        if not goingDown:
            return ans
        return ans + nums[-1]




