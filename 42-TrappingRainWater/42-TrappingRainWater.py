# Last updated: 5/31/2025, 4:29:30 PM
class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        stack = [0]
        res = 0
        for i in range(1,n):
            # print(stack)
            if not stack:
                stack.append(i)
                continue
            while stack and height[i] >= height[stack[-1]]:
                last = stack.pop()
                if not stack: break
                nxt = stack[-1]
                more = (min(height[i], height[nxt]) - height[last]) * (i - nxt - 1)
                # print("i: ", i, "; last: ",last, "; nxt: ",nxt, "; more: ",more)
                
                res += more # height * width
            stack.append(i)
        return res


        #time complexity On
        #space complexity On
        # n = len(height)
        # ans = 0
        # l = 0
        # r = n-1
        # pre_max = 0
        # suf_max = 0
        # while l <= r:
        #     pre_max = max(pre_max, height[l])
        #     suf_max = max(suf_max, height[r])
        #     if pre_max < suf_max:
        #         ans += pre_max - height[l]
        #         l += 1
        #     else:
        #         ans += suf_max - height[r]
        #         r -= 1
        # return ans
