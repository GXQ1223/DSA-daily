# Last updated: 5/30/2025, 3:20:04 PM
class Solution:
    def minCost(self, n: int, cuts: List[int]) -> int:
        # 1) sort once and close over it
        sorted_cuts = tuple(sorted(cuts))

        @cache
        def dfs(i: int, j: int) -> int:
            # 2) only consider cuts strictly inside (i, j)
            valid = [c for c in sorted_cuts if i < c < j]
            if not valid:
                return 0

            res = inf
            for cut in valid:
                cost = (j - i) \
                     + dfs(i, cut) \
                     + dfs(cut, j)
                res = min(res, cost)
            return res

        # 3) initial call only needs (0, n)
        return dfs(0, n)