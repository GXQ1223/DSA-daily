# Last updated: 6/25/2025, 8:41:11 PM
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:

        # edge cases
        if len(nums)==1: return 0
        if nums[-1]>nums[-2]: return len(nums)-1
        if nums[0]>nums[1]: return 0 
        

        l,r = 0, len(nums)
        while l < r:
            m = (l+r)//2
            if nums[m-1] < nums[m] > nums[m+1]: return m
            if nums[m] < nums[m+1]: l = m
            else: r = m