# Last updated: 9/7/2025, 8:13:33 PM
class Solution:
    def largestUniqueNumber(self, nums: List[int]) -> int:
        cnt = Counter(nums)
        maxx = -1
        for x in cnt.keys():
            if cnt[x] == 1:
                maxx = max(x, maxx)
        return maxx