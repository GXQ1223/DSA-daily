# Last updated: 6/6/2025, 3:49:44 PM
class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        counter = Counter(nums)
        n = len(nums)
        freq = 0
        for c in counter:
            if counter[c] > 1:
                freq += 1

        if freq == 0: return 0

        res, cur = 0, 0
        while cur < n:
            res += 1
            for i in range(0,3):
                counter[nums[cur + i]] -= 1
                if counter[nums[cur + i]] == 1:
                    freq -= 1
                    if freq == 0:
                        return res
            cur += 3

        return res + 1