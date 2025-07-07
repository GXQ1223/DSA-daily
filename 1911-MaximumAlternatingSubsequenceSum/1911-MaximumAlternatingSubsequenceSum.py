# Last updated: 7/7/2025, 7:11:27 PM
from typing import List

class Solution:
    def maxAlternatingSum(self, nums: List[int]) -> int:
        even = 0  # Max alternating sum ending in an even position
        odd = 0   # Max alternating sum ending in an odd position

        for num in nums:
            new_even = max(even, odd + num)
            new_odd = max(odd, even - num)
            even, odd = new_even, new_odd
        
        return even  # Result is always stored in `even`
