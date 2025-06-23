# Last updated: 6/23/2025, 6:27:14 PM
# def zero_one_knapsack(capacity: int, w: List(int), v: List(int)) -> int:
#     n = len(w)
     
#     @cache
#     def dfs(i,c):
#         if i < 0: return 0
#         if c < w[i]:
#             return dfs(i-1, c)
#             return max(dfs(i-c, c), dfs(i-1, c-w[i]) + v[i])
#     return dfs(n-1, capacity)

class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        n = len(nums)

        # p
        # s-p
        # p - (s-p) = t
        # 2p = s+t
        # p = (s+t)/2
        target += sum(nums)
        if target < 0 or target % 2:
            return 0
        target //= 2
        @cache
        def dfs(i, c):
            if i < 0:
                return 0 if c != 0 else 1
            if c < nums[i]:
                return dfs(i-1, c)
            return dfs(i-1, c) + dfs(i-1, c - nums[i])
        return dfs(len(nums) - 1, target)
        

        