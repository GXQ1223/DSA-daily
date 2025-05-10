# Last updated: 5/10/2025, 11:18:26 AM
def works(h: int, citations: List[int]) -> bool:
    # print(" given researcher has published at least ",h," papers that have each been cited at least ",h," times: ", len(citations) - h >= h)
    return citations[h] >= len(citations) - h
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        left, right = 0, len(citations) - 1 
        if citations[-1] == 0:
            return 0
        while left <= right:
            mid = (left + right) // 2
            if works(mid, citations):
                right = mid - 1
            else:
                left = mid + 1
        # print("left, right:",left,"; " ,right)
        return len(citations) - left
        