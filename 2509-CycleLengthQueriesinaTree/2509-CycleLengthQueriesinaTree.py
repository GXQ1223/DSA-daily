# Last updated: 6/9/2025, 3:28:37 PM
class Solution:
    def cycleLengthQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        res = []
        for x,y in queries:
            res.append(1)
            while x != y:
                x,y = min(x,y), max(x,y) // 2
                res[-1] += 1
        return res