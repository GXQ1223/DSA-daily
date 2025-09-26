# Last updated: 9/25/2025, 8:23:20 PM
class Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        nums.sort()
        n = len(nums)
        res = 0
        for i in range(n-1):
            for j in range(i+1, n):
                target = nums[i]+nums[j]
                l,r = j+1,n-1
                while l <= r:
                    m = (l+r)//2
                    if nums[m] < target:
                        l = m+1
                    else:
                        r = m-1
                res += r - j
        return res
