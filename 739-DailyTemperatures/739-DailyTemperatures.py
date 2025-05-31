# Last updated: 5/31/2025, 3:42:22 PM
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        stack = []
        res = []
        for i in range(n-1, -1, -1):
            t = temperatures[i]
            if not stack:
                stack.append(i)
                res.append(0)
                continue
            while stack and t >= temperatures[stack[-1]] :
                stack.pop()
            res.append(0 if not stack else stack[-1] - i)
            stack.append(i)
        res.reverse()
        return res