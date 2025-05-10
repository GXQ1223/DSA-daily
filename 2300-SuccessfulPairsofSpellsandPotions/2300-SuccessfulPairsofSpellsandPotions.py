# Last updated: 5/10/2025, 11:17:52 AM
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        left, right = 0, len(citations) - 1 
        if citations[-1] == 0:
            return 0
        while left <= right:
            mid = (left + right) // 2
            if citations[mid] >= len(citations) - mid:
                right = mid - 1
            else:
                left = mid + 1
        print("left, right:",left,"; " ,right)
        return len(citations) - left
        