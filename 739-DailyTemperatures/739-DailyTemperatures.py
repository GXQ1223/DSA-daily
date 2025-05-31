# Last updated: 5/31/2025, 3:51:04 PM
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
       
        # stack = []
        # res = []
        # for i in range(n-1, -1, -1):
        #     t = temperatures[i]
        #     if not stack:
        #         stack.append(i)
        #         res.append(0)
        #         continue
        #     while stack and t >= temperatures[stack[-1]] :
        #         stack.pop()
        #     res.append(0 if not stack else stack[-1] - i)
        #     stack.append(i)
        # res.reverse()
        # return res

        stack, res = [0], [0] * n
        for i in range(1, n):
            while stack and temperatures[i] > temperatures[stack[-1]]:
                res[stack[-1]] = i - stack[-1]
                stack.pop()
            stack.append(i)
        return res