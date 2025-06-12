# Last updated: 6/11/2025, 11:20:43 PM
class Solution:
    def maxAdjacentDistance(self, n: List[int]) -> int:
        return max([abs(n[i]-n[i-1])for i in range(len(n))])
        