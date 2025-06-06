# Last updated: 6/6/2025, 3:50:25 PM
from collections import Counter

class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        
        # digits = [i for i in range(1, 101)]
        # counts = Counter(nums)

        # steps = 0
        # while True:
        #     if all(counts[d] < 2 for d in digits):
        #         return steps
            
        #     steps += 1
        #     for num in nums[:3]:
        #         counts[num] -= 1
            
        #     nums = nums[3:]

        ans = 0

        unique = set(nums)
        while len(unique) != len(nums):
            nums = nums[3:]
            unique = set(nums)
            ans += 1

        return ans