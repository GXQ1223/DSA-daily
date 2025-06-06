# Last updated: 6/6/2025, 3:33:30 PM
class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        res, ind = [], 0
        for num in nums:
            res.append('0' if num[ind] == '1' else '1')
            ind += 1
        return "".join(res)