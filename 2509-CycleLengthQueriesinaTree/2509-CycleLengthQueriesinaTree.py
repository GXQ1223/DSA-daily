# Last updated: 6/9/2025, 3:30:36 PM
from typing import List
class Solution:
    def cycleLengthQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        res = []
        for a, b in queries:
            length = 1
            while a != b:
                if a > b:
                    a = a // 2
                else:
                    b = b // 2
                length += 1
            res.append(length)
        return res